package data_structures;

import data_structures.NoSpaceException;
import data_structures.Queue;

public class MyQueue<E> implements Queue<E> {
    protected E[] array;
    protected int start=0;
    protected int end=0;
    protected int length=0;

    public MyQueue(int size) {
        array = (E[]) new Object[size];
    }

    @Override
    public void enqueue(E value) {
        if (length >= array.length) {
            throw new NoSpaceException("No more space to add an element!");
        }
        array[end] = value;

        end = (end+1) % array.length;
        length++;
    }

    @Override
    public E dequeue() {
        if (length <= 0) {
            return null;
        }
        E value = array[start];
        start = (start+1) % array.length;
        length--;
        return value;
    }

    @Override
    public E peek() {
        if (length <= 0) {
            return null;
        }

        return array[start];
    }

}
