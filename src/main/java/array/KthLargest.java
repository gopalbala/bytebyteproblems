package array;

/**
 * Created by gbalasubramanian on 21/09/18.
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] array = {10, 4, 5, 8, 6, 11, 26};//{3, 9, 7, 5, 4};
        int elem = findKthLargest(array, 0, 6, 4);
        System.out.println(elem);
        int[] inp = {12, 11, 13, 5, 6, 7};

        for (int i=0;i<inp.length-1;i++) {
            inp = heapify(inp, inp.length - i);
            swap(inp,0,inp.length-i-1);

        }

    }

    public static int partition(int[] arr, int low, int high) {
        int i;
        int j = low;

        int mid = (low + high) / 2;
        swap(arr, mid, high);

        for (i = low; i < high; i++) {
            if (arr[i] > arr[high]) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, j, high);
        //System.out.println(arr[j]);
        return j;
    }

    static int findKthLargest(int[] arr, int low, int high, int k) {
        if (low < high) {
            int partition = partition(arr, low, high);
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            if (partition == k)
                return arr[k - 1];
            else if (partition > k) {
                return findKthLargest(arr, low, partition - 1, k);
            } else {
                return findKthLargest(arr, partition + 1, high, k);
            }
        }
        return 0;
    }

    static int[] heapify(int[] arr, int n) {
        for (int j = (n / 2) -1; j >= 0; j--) {
            int left = 2 * j + 1;
            int right = 2 * j + 2;
            if (left < n && arr[left] > arr[j]) {
                arr = swap(arr, left, j);
            }
            if (right < n && arr[right] > arr[j]) {
                arr = swap(arr, right, j);
            }
        }
        return arr;
    }

    static int[] swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return arr;
    }
}
