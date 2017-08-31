package com.gb.bytebybyteproblems;

/**
 * Created by gbalasubramanian on 30/08/17.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[][]{{false, false, false}, {false, true, false}, {false, false, false}};
        boolean firstRow = false, firstColumn = false;

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < arr[0].length; i++) {
            firstRow |= arr[0][i];
        }

        for (int j = 0; j < arr.length; j++) {
            firstColumn |= arr[j][0];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j]) {
                    arr[0][j] = true;
                    arr[i][0] = true;
                }
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0]) {
                for (int j = 1; j < arr[i].length; j++) {
                    arr[i][j] = true;
                }
            }
        }

        for (int j = 1; j < arr[0].length; j++) {
            if (arr[0][j]) {
                for (int i = 1; i < arr.length; i++) {
                    arr[i][j] = true;
                }
            }
        }

        if (firstRow) {
            for (int i = 0; i < arr[0].length; i++) {
                arr[0][i] = true;
            }
        }

        if (firstColumn) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = true;
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
