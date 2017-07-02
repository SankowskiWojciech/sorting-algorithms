import java.util.List;
import java.lang.Comparable;

public class RecursiveQuickSort<T extends Comparable<T>> {
    public void quickSort(List<T> list, int left, int right) {
        if(left < right) {
            int pivot = partition(list, left, right);
            quickSort(list, left, pivot - 1);
            quickSort(list, pivot + 1, right);
        }
    }

    private int partition(List<T> list, int left, int right) {
        T x = list.get(right);
        int i = left - 1;
        for(int j = left; j < right; j++) {
            if(list.get(j).compareTo(x) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, right);
        return i + 1;
    }

    private void swap(List<T> list, int i, int j) {
        T ob = list.get(i);
        list.set(i, list.get(j));
        list.set(j, ob);
    }
}
