package array;

/**
 * Created by gbalasubramanian on 31/07/18.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6 }, {7, 8, 9}};
        int first, last, i;
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(m);
        System.out.println(n);
        printMatrix(matrix);
        for (i = 0; i < m / 2; i++) {
            first = i;
            last = m - 1 - i;

            for (int j = i; j < last; j++) {
                int offset = j - first;
                int t = matrix[first][j];
                matrix[first][j] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[j][last];
                matrix[j][last] = t;

            }
            //printMatrix(matrix);
        }
        printMatrix(matrix);
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

