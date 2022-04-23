public class MyQueue<T> extends MyArrayList<T> {
    public T peek() {
        return get(0);
    }

    public T enqueue(T item) {
        add(item);
        return item;
    }

    public T dequeue() {
        T remove = peek();
        remove(0);
        return remove;
    }
}
