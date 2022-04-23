public class MyHeap<T> extends MyArrayList<T> {
    public void insert(T item) {
        add(item);
    }
    public void removeRoot(T index){
        remove(0);
    }
    public void removefromheap(T item){
        remove(item);
    }
    private void heapify(){

    }
}
