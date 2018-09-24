package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    protected E value;
    protected Node next;

    protected static class Node<E> {
        protected E value;
        protected Node next;

        public String toString() {
            return value.toString();
        }
    }

    int length = 0;
    Node<E>[] lastModifiedNode;
    Node<E> first;
    Node<E> last;

    protected Node<E> getNewNode() {
        Node<E> node = new Node<>();
        lastModifiedNode = new Node[] {node};
        return node;
    }

    public Node<E> appendLast(E value) {
        Node node = getNewNode();
        node.value = value;

        if (last != null)
            last.next = node;

        last = node;

        if (first == null)
            first = node;

        length++;
        return node;

    }

    public Node<E> appendFirst(E value) {
        Node node = getNewNode();
        node.value = value;
        node.next = first;
        first = node;
        if (length == 0)
            last = node;
        length++;
        return node;
    }
    
    public Node<E> insert(int index, E value) {
        Node<E> node = getNewNode();

        if(index < 0 || index > length) {
            throw new IllegalArgumentException("Invalid index for insertion");
        } else if (index == length) {
            return appendLast(value);
        } else if (index == 0) {
            return appendFirst(value);
        } else {
            Node<E> result = first;
            while (index > 1) {
                index--;
                result = result.next;
            }
            node.value = value;
            node.next = result.next;
            result.next = node;
            length++;
            return node;
        }
    }

    public E findAtIndex(int index) {
        Node<E> result = first;
        while (index >= 0) {
            if (result == null) {
                throw new NoSuchElementException();
            } else if (index == 0) {
                return result.value;
            } else {
                index--;
                result = result.next;
            }
        }
        return null;
    }

    public Node<E> removeFirst() {
        if (length == 0) {
            throw new NoSuchElementException();
        }

        Node<E> origFirst = first;
        first = first.next;
        length--;

        if (length == 0)
            last = null;

        return origFirst;
    }

    protected Node<E> removeAtIndex(int index) {
        if (index >= length || index < 0) {
            throw new NoSuchElementException();
        }

        if (index == 0) {
            Node<E> nodeRemoved = first;
            removeFirst();
            return nodeRemoved;
        }
        
        Node justBeforeIt = first;
        while (--index > 0) {
            justBeforeIt = justBeforeIt.next;
        }

        Node<E> nodeRemoved = justBeforeIt.next;
        if (justBeforeIt.next == last) {
            last = justBeforeIt.next.next;
        }

        justBeforeIt.next = justBeforeIt.next.next;
        length--;
        return nodeRemoved;
    }

    protected class ListIterator implements Iterator<E> {
        protected Node<E> nextNode = first;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) 
                throw new IllegalStateException();
            Node<E> nodeToReturn = nextNode;
            nextNode = nextNode.next;
            return nodeToReturn.value;
        }

    }
//        @Override
//        public Iterator<E> iterator() {
//            return new ListIterator();
//        }
//

}
