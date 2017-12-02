package array;

/**
 * Created by gbalasubramanian on 18/11/17.
 */
public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr.length;
        int key = 10;
        int i = search(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }

    static int search(int[] arr, int start, int end, int elem) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == elem)
            return mid;
        if (arr[start] <= arr[mid]) {
            if (elem >= arr[start] && elem <= arr[mid])
                return search(arr, start, mid - 1, elem);
            return search(arr, mid + 1, end, elem);
        }
        if (elem >= arr[mid] && elem <= arr[end])
            search(arr, mid + 1, end, elem);

        return search(arr, start, mid - 1, elem);

    }
}
