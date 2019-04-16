package array;

/**
 * Created by gbalasubramanian on 28/01/19.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class ClosestNumber {
    public static void main (String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();
        int[][] inputs = new int[numberOfInputs][2];
        for(int i =0;i<numberOfInputs;i++){
            inputs[i][0] = scanner.nextInt();
            inputs[i][1] = scanner.nextInt();
        }
        for(int i=0;i<numberOfInputs;i++){

            int quotient = inputs[i][0] / inputs[i][1];

            int next = (int)Math.ceil(1.0 * inputs[i][0]/inputs[i][1]) * inputs[i][1];
            int prev = (int)Math.floor(1.0 * inputs[i][0]/inputs[i][1]) * inputs[i][1];

            if (prev< 0 && next < 0 && prev > next) {
                int temp = next;
                next = prev;
                prev = temp;
            }

            if(inputs[i][0] > 0 && inputs[i][1] < 0){
                int temp = next;
                next = prev;
                prev = temp;
            }

            if(next - inputs[i][0] > inputs[i][0] - prev)
                System.out.println(prev);
            else if(next - inputs[i][0] < inputs[i][0] - prev)
                System.out.println(next);
            else
                System.out.println(inputs[i][0] * inputs[i][1] > 0 ? next: prev);
//             int nextRem = next  % inputs[i][0];
//             //System.out.println(next +":"+nextRem);
//             if(Math.abs(rem) == Math.abs(nextRem)) {
//                 System.out.println(inputs[i][0] + nextRem);
//             } else {
//                 System.out.println(inputs[i][1] * quotient);
//             }
            closestNumber(inputs[i][0],inputs[i][1]);
        }
    }


    public static int closestNumber(int N, int M) {
        int hi = (int) Math.ceil(1.0 * N / M) * M;
        int lo = (int) Math.floor(1.0 * N / M) * M;

        if (N > 0 && M < 0) {
            int temp = hi;
            hi = lo;
            lo = temp;
        }

        if (hi - N > N - lo) {
            return lo;
        } else if (hi - N < N - lo) {
            return hi;
        } else {
            return N * M > 0 ? hi : lo;
        }
    }

}
