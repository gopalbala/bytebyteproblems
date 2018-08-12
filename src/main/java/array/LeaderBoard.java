package array;

import dynamicprogramming.Lis;

import java.io.IOException;
import java.util.*;

/**
 * Created by gbalasubramanian on 08/08/18.
 */
public class LeaderBoard {
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] output = new int[alice.length];
        Integer[] nInp = new Integer[scores.length + 1];
        for (int i=0;i<scores.length;i++)
            nInp[i] = scores[i];

        int j = 0;
        for (int i : alice) {
            nInp[scores.length] = i;
            nInp = insertionSort(nInp, nInp.length);
            int i1 = getIntegerIntegerHashtable(nInp, i);
            output[j++] = i1;
        }

        return output;
    }

    static Integer[] insertionSort(Integer A[], int size)
    {
        int i, key, j;
        for (i = 1; i < size; i++)
        {
            key = A[i];
            j = i-1;

       /* Move elements of A[0..i-1], that are greater than key, to one
          position ahead of their current position.
          This loop will run at most k times */
            while (j >= 0 && A[j] < key)
            {
                A[j+1] = A[j];
                j = j-1;
            }
            A[j+1] = key;
        }

        return A;
    }

    private static int getIntegerIntegerHashtable(Integer[] scores, int num) {
        int rank = 0;

        //Arrays.sort(scores,Comparator.reverseOrder());


        int prev = 0;
        int rnk = 0;



        for (int i : scores) {
            int current = i;
            if (current != prev) {
                prev = current;
                rnk++;
                if (current == num)
                    break;
            }
        }
        return rnk;
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());
//        for (int i : scores) {
//            priorityQueue.add(i);
//        }
//
//        priorityQueue.add(num);
//
//        int previousNumbner = 0;
//        while (!priorityQueue.isEmpty()) {
//            int currentNumber = priorityQueue.remove();
//            if (currentNumber != previousNumbner) {
//                previousNumbner = currentNumber;
//                rank++;
//                if (currentNumber == num)
//                    break;
//            }
//
//        }
//        return rank;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] ints = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};
//        int[] output = climbingLeaderboard(ints, alice);
//        for (int i : output) {
//            System.out.print(i + " ");
//        }

        List<Integer> integers = new ArrayList<>();
        int prev = 0;
        for (int i: ints) {
            if (i != prev) {
                integers.add(i);
                prev = i;
            }
        }

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        for (int i : alice) {
            int j = Collections.binarySearch(integers,i,cmp);
            if (j< 0)
                j = -j-1;
            System.out.println(j+1);
        }


        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int scoresCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] scores = new int[scoresCount];
//
//        String[] scoresItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < scoresCount; i++) {
//            int scoresItem = Integer.parseInt(scoresItems[i]);
//            scores[i] = scoresItem;
//        }
//
//        int aliceCount = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] alice = new int[aliceCount];
//
//        String[] aliceItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < aliceCount; i++) {
//            int aliceItem = Integer.parseInt(aliceItems[i]);
//            alice[i] = aliceItem;
//        }
//
//        int[] result = climbingLeaderboard(scores, alice);
//
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}


