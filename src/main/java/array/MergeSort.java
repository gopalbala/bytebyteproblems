package array;

/**
 * Created by gbalasubramanian on 20/11/17.
 */
public class MergeSort {
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) {
        arr = new int[]{45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        temp = new int[10];
        mergeSort(0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;

        mergeSort(low, middle);
        mergeSort(middle + 1, high);
        merge(low, middle, high);
    }

    static void merge(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while ((i <= mid) && (j <= high)) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

    }
}
