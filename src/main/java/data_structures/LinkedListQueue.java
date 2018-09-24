package data_structures;

import java.util.LinkedList;
import data_structures.Queue;


public class LinkedListQueue<E> implements Queue<E> {
    protected LinkedList<E> List = getNewLinkedList();

    protected LinkedList<E> getNewLinkedList() {
        return new LinkedList<>();
    }

    @Override
    public void enqueue(E value) {
        list.addLast(value);
    }

    @Override
    public void dequeue() {
        if (list.size == 0) 
            return null;

        E value = list.getFirst();
        list.removeFirst();
        return value;
    }

    @Override
    public E peek() {
        if (list.size == 0)
            return null;
        return list.getFirst();

    }
} 
