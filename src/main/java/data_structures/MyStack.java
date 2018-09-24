package data_structures;

import data_structures.Stack;
import data_structures.NoSpaceException;


public class MyStack<E> implements Stack<E> {
    protected E[] array;

    int top =- 1;

    public MyStack(int size) {
        array = (E[])new Object[size];
    }

    @Override
    public void push(E value) {
        if (top == array.length-1) {
            throw new NoSpaceException("No more space in stack");
        }
        top++;
        array[top] = value;
    }

    @Override
    public E pop() {
        if (top == -1) {
            return null;
        }

        top--;
        return array[top+1];
    }

    @Override
    public E peek() {
        if (top == -1) {
            return null;
        }
        return array[top];
    }

}
