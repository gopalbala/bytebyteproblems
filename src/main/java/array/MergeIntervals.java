package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by gbalasubramanian on 02/01/19.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        intervals.sort(Comparator.comparingInt(o -> o.arrival));
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(1, 9);
        arr[1] = new Interval(2, 4);
        arr[2] = new Interval(4, 7);
        arr[3] = new Interval(6, 4);

        Arrays.sort(arr, Comparator.comparingInt(o -> o.arrival));

        int index = 0;

        List<Interval> output = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (index != 0 && arr[index - 1].arrival <= arr[index].departure) {
                while (index != 0 && arr[index - 1].arrival <= arr[index].departure) {
                    arr[index - 1].departure = Math.max(arr[index - 1].departure, arr[i].departure);
                    arr[index - 1].arrival = Math.min(arr[index - 1].arrival, arr[i].arrival);
                    index --;
                }
            } else {
                arr[index] = arr[i];
            }
            index++;
        }

        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i < index; i++)
            System.out.print("["+arr[i].arrival+","+arr[i].departure+"]");
    }
}

class Interval {
    int arrival;
    int departure;

    public Interval() {
    }

    public Interval(int arr, int dep) {
        this.arrival = arr;
        this.departure = dep;
    }
}
