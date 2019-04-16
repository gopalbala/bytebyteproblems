package array;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Created by gbalasubramanian on 29/01/19.
 */
public class PrintKthDigit {	public static void main (String[] args) {
    //code
    Scanner scanner = new Scanner(System.in);
    int numberOfInputs = scanner.nextInt();
    int[][] inputs = new int[numberOfInputs][3];
    for(int i =0;i<numberOfInputs;i++){
        inputs[i][0] = scanner.nextInt();
        inputs[i][1] = scanner.nextInt();
        inputs[i][2] = scanner.nextInt();
    }
    for(int i =0;i<numberOfInputs;i++){
        int kthDigit =  printKthDigit(inputs[i][0], inputs[i][1],inputs[i][2]);
        System.out.println(kthDigit);
    }


}

    static int printKthDigit(int number, int power, int k) {
        long kthPower = (long) Math.pow(number, power);
        int count = 0;
        while(kthPower > 0) {
            long rem = kthPower % 10;
            count++;
            if (count == k){
                return (int)rem;
            }
            kthPower = kthPower / 10;
        }
        return 0;
    }
}
