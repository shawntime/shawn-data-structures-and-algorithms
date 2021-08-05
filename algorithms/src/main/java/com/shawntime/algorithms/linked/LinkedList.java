package com.shawntime.algorithms.linked;

import com.shawntime.algorithms.AbstractList;

/**
 * 单向链表
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> first;

    @Override
    public boolean add(E element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> node = getNode(index - 1);
            Node<E> nextNode = node.next;
            node.next = new Node<>(element, nextNode);
        }
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
        if (size == 0) {
            return null;
        }
        E element;
        if (index == 0) {
            element = first.element;
            first = first.next;
        } else {
            Node<E> node = getNode(index - 1);
            Node<E> nextNode = node.next;
            element = nextNode.element;
            node.next = nextNode.next;
        }
        size--;
        return element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        int index = 0;
        if (element == null) {
            while (node != null) {
                if (first.element == null) {
                    return index;
                }
                index++;
                node = node.next;
            }
        } else {
            while (node != null) {
                if (element.equals(node.element)) {
                    return index;
                }
                index++;
                node = node.next;
            }
        }
        return INDEX_NOT_FOUND;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        E oldElement;
        if (index == 0) {
            oldElement = first.element;
            first.setElement(element);
        } else {
            Node<E> node = getNode(index);
            oldElement = node.element;
            node.setElement(element);
        }
        return oldElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Size : " + size + ", Data : ");
        Node<E> node = first;
        while (node != null) {
            sb.append(node.element).append(", ");
            node = node.next;
        }
        String info = sb.toString();
        return info.substring(0, info.length() - 2);
    }

    private Node<E> getNode(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; ++i) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {

        E element;

        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
