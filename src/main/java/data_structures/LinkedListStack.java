package data_structures;

import java.util.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
    protected LinkedList<E> list = getNewLinkedList();

    protected LinkedList<E> getNewLinkedList() {
        return new LinkedList<>();
    }

    @Override
    public void push(E value) {
        list.addFirst(value);
    }

    @Override
    public E pop() {
        if (list.size() == 0) {
            return null;
        }

        E value = list.getFirst();
        list.removeFirst();
        return value;
    }

    @Override
    public E peek() {
        if (list.size() == 0) {
            return null;
        }

        return list.getFirst();
    }
}

