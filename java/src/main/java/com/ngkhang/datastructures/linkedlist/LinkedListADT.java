package com.ngkhang.datastructures.linkedlist;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Linked List ADT interface
 * @param <E> the type of elements held in this list
 */
public interface LinkedListADT<E> {
    /**
     * Returns the first element in this list
     *
     * @return the first element in this list
     * @throws NoSuchElementException if the list is empty
     */
    public E getFirst();

    /**
     * Returns the last element in this list
     *
     * @return the last element in this list
     * @throws NoSuchElementException if the list is empty
     */
    public E getLast();

    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element to retrieve (0-indexed)
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()
     */
    public E get(int index);

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addFirst(E e);

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e the element to add
     */
    public void addLast(E e);

    /**
     * Inserts the specified element at the specified index.
     *
     * @param e     the element to be inserted
     * @param index the index at which the element should be inserted (0-indexed)
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    public void add(E e, int index);

    /**
     * Removes and returns the first element from this list.
     *
     * @return the removed element
     * @throws NoSuchElementException if this list is empty
     */
    public E removeFirst();

    /**
     * Removes and returns the last element from this list.
     *
     * @return the removed element
     * @throws NoSuchElementException if this list is empty
     */
    public E removeLast();

    /**
     * Removes and returns the specified element at the specified index.
     *
     * @param index the index of the element to remove (0-indexed)
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     * @throws NoSuchElementException if this list is empty
     */
    public E remove(int index);

    /**
     * Searches for the specified value in this list.
     *
     * @param value the value to search for
     * @return an Optional containing the value if found, or empty Optional if not found
     */
    public Optional<E> find(E value);

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param value to check for equality
     * @return {@code true} if this list contains the specified element
     */
    public boolean contains(E value);

    /**
     * Checks if the list is empty
     *
     * @return {@code true} if list is empty, otherwise {@code false}.
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list
     *
     * @return the number of elements in this list
     */
    public int size();

    /**
     * Removes all the elements from this list.
     */
    public void clear();
}
