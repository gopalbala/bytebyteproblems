package array;

/**
 * Created by gbalasubramanian on 20/11/17.
 */
public class Sort012 {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort(arr);
    }

    static void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0, temp = 0;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
                }
            }
        }
        for (int i:arr) {
            System.out.print(i);

        }
    }
}
