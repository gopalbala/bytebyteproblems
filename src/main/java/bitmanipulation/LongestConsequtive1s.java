package bitmanipulation;

/**
 * Created by gbalasubramanian on 04/08/18.
 */
public class LongestConsequtive1s {
    public static void main(String[] args) {
        //System.out.println(maxConsecutiveOnes(14));
        System.out.println(maxConsecutiveOnes(222));

    }
    private static int maxConsecutiveOnes(int x)
    {
        // Initialize result
        int count = 0;

        // Count the number of iterations to
        // reach x = 0.
        while (x!=0)
        {
            // This operation reduces length
            // of every sequence of 1s by one.
            x = (x & (x << 1));
            System.out.println((x<<1) + ":" + Integer.toBinaryString(x<<1));

            count++;
        }

        return count;
    }
}
