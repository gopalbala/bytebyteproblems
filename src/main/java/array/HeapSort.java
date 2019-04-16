package array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gbalasubramanian on 23/11/17.
 */
public class HeapSort {
    static int[] arr;
    static int size;

    public static void main(String[] args) {
        arr = new int[5];

        for (int i = 1; i <= 5; i++) {
            push(i);
        }


        Arrays.sort(arr);
        for (int i = 0; i < 5; i++) {
            pop();
        }
    }

    static void sort(int[] arr) {

    }

    static void push(int elem) {
        int pos = size;

        arr[pos] = elem;
        while (pos > 0) {
            int parent = (pos + 1) / 2 - 1;
            if (arr[parent] > arr[pos]) break;
            swap(parent, pos);
            pos = parent;
        }
        size++;
    }

    static int pop() {
        int elem = arr[0];
        arr[0] = arr[size];
        size--;
        int pos = 0;
        while (pos < size / 2) {
            int leftChild = pos * 2 + 1;
            int rightChild = leftChild + 1;
            if (rightChild < size && arr[leftChild] < arr[rightChild]) {
                swap(pos, rightChild);
            } else {
                if (arr[pos] > arr[leftChild])
                    break;
                swap(pos, leftChild);
                pos = leftChild;
            }
        }
        return elem;
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
