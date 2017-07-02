import java.util.List;
import java.lang.Comparable;

public class InsertionSort<T extends Comparable<T>> {
    public void sort(List<T> list) {
        if(list.size() < 2)
            return;
        for(int j = 1; j < list.size(); j++) {
            T item = list.get(j);
            int i = j - 1;
            while(i >= 0 && list.get(i).compareTo(item) > 0) {
                list.set(i + 1, list.get(i));
                i--;
            }
            list.set(i + 1, item);
        }
    }
}
