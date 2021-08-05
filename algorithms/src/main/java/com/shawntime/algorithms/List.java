package com.shawntime.algorithms;

public interface List<E> {

    int INDEX_NOT_FOUND = -1;

    boolean add(E element);

    boolean add(int index, E element);

    boolean remove(E element);

    E remove(int index);

    int indexOf(E element);

    boolean contains(E element);

    void clear();

    boolean isEmpty();

    int size();

    E get(int index);

    E set(int index, E element);
}
