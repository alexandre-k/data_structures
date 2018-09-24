package data_structures;

import data_structures.MyLinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    @Test
    @DisplayName("general behavior")
    public void testGeneralBehavior() {
        MyLinkedList list = new MyLinkedList();
        assertEquals(list.first, null);
        assertEquals(list.last, null);
        list.appendLast(5);
        list.appendLast(10);
        list.appendFirst(15);

        assertEquals(list.length, 3);
        assertEquals(list.first.value, 15);
        assertEquals(list.last.value, 10);
        assertEquals(list.findAtIndex(1), 5);
        list.removeAtIndex(2);
        assertEquals(list.length, 2);
        list.removeFirst();
        assertEquals(list.length, 1);
        assertEquals(list.first.value, 5);
    }

    @Test
    @DisplayName("test appendLast")
    public void testAppendLast() {
        MyLinkedList list = new MyLinkedList();
        list.appendLast(5);
        assertEquals(list.length, 1);
        assertEquals(list.first.value, 5);
        assertEquals(list.last.value, 5);
    }

    @Test
    @DisplayName("test appendFirst")
    public void testAppendFirst() {
        MyLinkedList list = new MyLinkedList();
        list.appendFirst(15);
        assertEquals(list.length, 1);
        assertEquals(list.first.value, 15);
        assertEquals(list.last.value, 15);
    }

    @Test
    @DisplayName("test removeAtIndex")
    public void testRemovedAtIndex() {
        MyLinkedList list = new MyLinkedList();
        list.appendFirst(15);
        list.removeAtIndex(0);
        assertEquals(list.length, 0);
        assertEquals(list.first, null);
        assertEquals(list.last, null);

        list.appendFirst(5);
        list.appendFirst(15);
        list.removeAtIndex(0);
        assertEquals(list.length, 1);
        assertEquals(list.first.value, 5);
        assertEquals(list.last.value, 5);
    }

    @Test
    @DisplayName("test removeFirst")
    public void testRemoveFirst() {
        MyLinkedList list = new MyLinkedList();
        list.appendFirst(15);
        list.removeFirst();
        assertEquals(list.length, 0);
        assertEquals(list.first, null);
        assertEquals(list.last, null);

        list.appendFirst(5);
        list.appendFirst(15);
        list.removeFirst();
        assertEquals(list.length, 1);
        assertEquals(list.first.value, 5);
        assertEquals(list.last.value, 5);
    }

    @Test
    @DisplayName("test findAtIndex")
    public void testFindAtIndex() {
        MyLinkedList list = new MyLinkedList();
        list.appendFirst(15);
        list.removeFirst();
        assertEquals(list.length, 0);
        assertEquals(list.first, null);
        assertEquals(list.last, null);

        list.appendFirst(5);
        list.appendFirst(15);
        
        assertEquals(list.findAtIndex(1), 5);
        assertEquals(list.findAtIndex(0), 15);
    }

}
