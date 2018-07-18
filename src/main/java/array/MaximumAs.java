package array;

/**
 * Created by gbalasubramanian on 02/06/18.
 */
public class MaximumAs {
    public static void main(String[] args) {
        int n= 8;
        int[] arr = new int[]{-1,-1,-1,-1,-1,-1,-1,-1};
        System.out.println(findMaxAs(n,arr));
        System.out.println(arr);

    }

    public static int findMaxAs(int n, int[] maxAsSolution) {
        if (n < 0)
            return -1;
        if (n <= 6)
            return n;
        int maxAsSofar = 0, multiplier = 2, maxWithThisi = 0;
        for (int i = n - 3; i >= 0; i--) {
            if (maxAsSolution[i] == -1) {
                maxAsSolution[i] = findMaxAs(i, maxAsSolution);
            }
            maxWithThisi = multiplier * maxAsSolution[i];
            if (maxWithThisi > maxAsSofar) {
                maxAsSofar = maxWithThisi;
            }
            multiplier += 1;
        }
        return maxAsSofar;
    }
}
