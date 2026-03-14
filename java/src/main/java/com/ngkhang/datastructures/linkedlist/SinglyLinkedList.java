package com.ngkhang.datastructures.linkedlist;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * A generic implementation of a singly linked list
 * <br/>This implementation maintains references to both head and tail for efficient operations.
 *
 * @param <E> the type of elements held in the list
 */
public class SinglyLinkedList<E> implements LinkedListADT<E> {
    private Node<E> head;
    private Node<E> tail;

    /**
     * Constructs an empty SinglyLinkedList.
     */
    public SinglyLinkedList() {
        this.head = this.tail = null;
    }

    /**
     * Constructs a SinglyLinkedList with an initial value.
     *
     * @param initialValue the initial value for the list
     */
    public SinglyLinkedList(E initialValue) {
        this.head = new Node<>(initialValue);
        this.tail = this.head;
    }

    /**
     * Constructs a SinglyLinkedList with an initial node.
     *
     * @param initialNode the initial node for the list
     */
    public SinglyLinkedList(Node<E> initialNode) {
        this.head = initialNode;
        this.tail = this.head;
    }

    @Override
    public E getFirst() {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");

        return this.head.value;
    }

    @Override
    public E getLast() {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");

        return this.tail.value;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size())
            throw new IndexOutOfBoundsException("Index out of bounds for length: " + this.size() + " and index: " + index);

        if (index == 0) return this.getFirst();
        if (index == this.size() - 1) return this.getLast();

        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    @Override
    public void add(E e, int index) {
        int size = this.size();

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index out of bounds for length: " + size + " and index: " + index);

        if (index == 0) this.addFirst(e);
        else if (index == size) this.addLast(e);
        else {
            Node<E> current = this.head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node<E> newNode = new Node<>(e);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    @Override
    public E removeFirst() {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");

        Node<E> removedNode = this.head;

        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
        }

        return removedNode.value;
    }

    @Override
    public E removeLast() {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");

        Node<E> removedNode = this.tail;

        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            Node<E> current = this.head;

            while (current.next != this.tail) {
                current = current.next;
            }

            current.next = null;
            this.tail = current;
        }

        return removedNode.value;
    }

    @Override
    public E remove(int index) {
        if (this.isEmpty()) throw new NoSuchElementException("List is empty");

        int size = this.size();

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds for length: " + size + " and index: " + index);

        if (index == 0) return this.removeFirst();
        if (index == size - 1) return this.removeLast();

        Node<E> current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node<E> removedNode = current.next;
        current.next = removedNode.next;

        return removedNode.value;
    }

    @Override
    public Optional<E> find(E value) {
        if (this.isEmpty()) return Optional.empty();

        Node<E> current = this.head;

        while (current != null) {
            if (current.value.equals(value)) return Optional.of(current.value);

            current = current.next;
        }

        return Optional.empty();
    }

    @Override
    public boolean contains(E value) {
        if (this.head == null) return false;

        Node<E> current = this.head;

        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public int size() {
        if (this.isEmpty()) return 0;

        int count = 0;
        Node<E> current = this.head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void clear() {
        this.head = this.tail = null;
    }

    /**
     * Returns a string representation of the list.
     * Format: [value1, value2, value3, ...]
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");

        Node<E> current = this.head;

        while (current != null) {
            joiner.add(current.value + "");
            current = current.next;
        }

        return "[" + joiner.toString() + "]";
    }

    /**
     * A node in the singly linked list.
     * Contains a value and a reference to the next node.
     *
     * @param <E> the type of value held in the node
     */
    private class Node<E> {
        private E value;
        private Node<E> next;

        /**
         * Constructs a node with the specified value.
         *
         * @param value the value to hold
         */
        public Node(E value) {
            this.value = value;
        }

        /**
         * Constructs a node with the specified value and next reference.
         *
         * @param value the value to hold
         * @param next  the reference to the next node
         */
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", next=" + next + "}";
        }
    }
}
