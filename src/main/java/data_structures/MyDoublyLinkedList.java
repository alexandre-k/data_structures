package data_structures;

import java.util.Arrays;
import java.util.NoSuchElementException;
import data_structures.MyLinkedList;


public class MyDoublyLinkedList<E> extends MyLinkedList<E> {

    protected static class DoublyLinkedNode<E> extends Node<E> {
        protected DoublyLinkedNode<E> prev;
    }

    @Override
    protected Node<E> getNewNode() {
        return new DoublyLinkedNode<E>();
    }
    
    public Node<E> appendFirst(E value) {
        Node<E> node = super.appendFirst(value);
        if (first.next != null)
            ((DoublyLinkedNode<E>) first.next).prev = (DoublyLinkedNode<E>) first;
        return node;
    }

    public Node<E> appendLast(E value) {
        DoublyLinkedNode<E> origLast = (DoublyLinkedNode) this.last;
        Node<E> node = super.appendLast(value);

        if (origLast == null) {
            origLast = (DoublyLinkedNode<E>) first;
        }
        ((DoublyLinkedNode<E>) this.last).prev = origLast;
        return node;
    }

    public Node<E> insert(int index, E value) {
        DoublyLinkedNode<E> inserted = (DoublyLinkedNode<E>) super.insert(index, value);

        if (index!=0 && index!=length) {
            if (inserted.next != null) {
                inserted.prev = ((DoublyLinkedNode<E>) inserted.next).prev;
                ((DoublyLinkedNode<E>) inserted.next).prev = inserted;
            }
        }
        return inserted;
    }

    public Node<E> removeFirst() {
        super.removeFirst();
        if (first != null) {
            ((DoublyLinkedNode<E>) first) .prev = null;
        }

        return first;
    }

    public Node<E> removeAtIndex(int index) {
        if (index<0 || index>=length) {
            throw new NoSuchElementException();
        }

        if (index == length-1) {
            return removeLast();
        }

        DoublyLinkedNode<E> nodeRemoved = (DoublyLinkedNode<E>) super.removeAtIndex(index);
        if ((DoublyLinkedNode<E>) nodeRemoved.next != null)
            ((DoublyLinkedNode<E>) nodeRemoved.next).prev = nodeRemoved.prev;
        return nodeRemoved;
    }

    public Node<E> removeLast() {
        Node<E> origLast = last;
        if (last == null) {
            throw new IllegalStateException("Removing element from an empty list");
        }

        last = ((DoublyLinkedNode<E>)last).prev;

        if (last!=null) {
            last.next = null;
        } else {
            first = null;
        }

        length--;
        return origLast;
    }
}
