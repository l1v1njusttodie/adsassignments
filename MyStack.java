public class MyStack<T> extends MyArrayList<T> {
    public T push(T item) {
        add(item);
        return item;
    }
    public T peek() {
        return get(length - 1);
    }
    public T pop() {
        T remove = peek();
        remove(length - 1);
        return remove;
    }
}
