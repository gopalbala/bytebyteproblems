package sorting;

/**
 * Created by fax6 on 05/12/17.
 */
public class Heap {
    Integer[] arr;
    int currentPosition = -1;

    public Heap() {
        arr = new Integer[10];
    }

    public int[] heapSort(int[] a) {
        return a;
    }

    public void heapsort() {
        for (int i = 0; i <= currentPosition; i++) {
            int temp = arr[0];
            System.out.println(temp);
            arr[0] = arr[currentPosition - i];
            arr[currentPosition - i] = temp;
            fixDown(0, currentPosition - i - 1);
        }
    }

    public void insert(int elem) {
        if (currentPosition > arr.length - 1) {
            throw new RuntimeException("max size reached");
        }
        arr[++currentPosition] = elem;
        fixUp(currentPosition);
    }

    private void fixUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0 && arr[parentIndex] < arr[index]) {
            int n = arr[index];
            arr[index] = arr[parentIndex];
            arr[parentIndex] = n;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int getMax() {
        int max = arr[0];
        arr[0] = arr[currentPosition--];
        arr[currentPosition + 1] = null;
        fixDown(0, -1);
        return max;
    }

    private void fixDown(int index, int upto) {
        if (upto < 0)
            upto = currentPosition;
        while (index <= upto) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left <= upto) {
                int childToSwap;
                if (right > upto) {
                    childToSwap = left;
                } else {
                    childToSwap = arr[left] > arr[right] ? left : right;
                }
                if (arr[index] < arr[childToSwap]) {
                    int temp = arr[index];
                    arr[index] = arr[childToSwap];
                    arr[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }
        }
    }
}
