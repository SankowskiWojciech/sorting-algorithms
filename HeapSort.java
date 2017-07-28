import java.util.ArrayList;
import java.util.List;

public class HeapSort<T extends Comparable<T>> {
    private List<T> heap;

    public HeapSort(List<T> heap) {
        this.heap = heap;
        buildHeap();
    }

    public List<T> getHeap() {
        return heap;
    }

    public void setHeap(List<T> heap) {
        this.heap = heap;
        buildHeap();
    }

    public void sort() {
        List<T> sorted = new ArrayList<>(heap.size());
        for(int i = heap.size() - 1; i >= 0; i--) {
            swap(0, i);
            sorted.add(heap.remove(i));
            heapify(0);
        }
        heap = sorted;
    }

    private void heapify(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int greatest;
        if(left < heap.size() && heap.get(left).compareTo(heap.get(i)) > 0)
            greatest = left;
        else
            greatest = i;
        if(right < heap.size() && heap.get(right).compareTo(heap.get(greatest)) > 0)
            greatest = right;
        if(greatest != i) {
            swap(i, greatest);
            heapify(greatest);
        }
    }

    private void buildHeap() {
        for(int i = (int)(heap.size() / 2); i >= 0; i-- )
            heapify(i);
    }

    private void swap(int i, int j) {
        T ob = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, ob);
    }
}
