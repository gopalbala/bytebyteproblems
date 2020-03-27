package array;

import java.util.Scanner;

public class StarPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
    }

    private static void printPattern(int n) {
        int n1 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n1; j++) {
                System.out.print("*");
            }
            System.out.println();
            n1 += 2;
        }
    }
}
