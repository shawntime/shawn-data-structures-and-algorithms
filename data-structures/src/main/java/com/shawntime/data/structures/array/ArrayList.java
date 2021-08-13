package com.shawntime.data.structures.array;

import com.shawntime.data.structures.AbstractList;

public class ArrayList<E> extends AbstractList<E> {

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 16;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            elements = (E[]) new Object[capacity];
        }
    }

    @Override
    public boolean add(E element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, E element) {
        // 参数校验
        rangeCheckForAdd(index);
        // 扩容
        ensureCapacity();
        // 添加
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(E element) {
        E oldElement = remove(indexOf(element));
        return oldElement != null;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E element = elements[index];
        for (int i = index; i < size - 1; ++i) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;
        reduceCapacity();
        return element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; ++i) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; ++i) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; ++i) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        E oleElement = get(index);
        elements[index] = element;
        return oleElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Size : " + size + ", Data : ");
        for (int i = 0; i < size; ++i) {
            sb.append(elements[i]).append(", ");
        }
        String info = sb.toString();
        return info.substring(0, info.length() - 2);
    }

    /**
     * 扩容
     */
    private void ensureCapacity() {
        int length = elements.length;
        if (size == length - 1) {
            // 1.5倍
            int newLength = length + (length >> 1);
            E[] newElements = (E[]) new Object[newLength];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    /**
     * 缩容
     */
    private void reduceCapacity() {
        int length = elements.length;
        if (size <= length >> 2) {
            // 1倍
            int newLength = length >> 2;
            E[] newElements = (E[]) new Object[newLength];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
}
