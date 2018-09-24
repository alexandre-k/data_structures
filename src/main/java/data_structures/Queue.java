package data_structures;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    E peek();
}
