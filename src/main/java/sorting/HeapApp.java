package sorting;

/**
 * Created by fax6 on 05/12/17.
 */
public class HeapApp {
    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.insert(10);
        heap.insert(100);
        heap.insert(9);

        heap.heapsort();

        System.out.println();
        System.out.println(heap.getMax());
    }
}
