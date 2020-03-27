package array;

public class CountKDivpairs {

    static int countKdivPairs(int A[], int n, int K)
    {
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        int []freq = new int[K];

        // To store count of pairs.
        int ans = 0;

        // Traverse the array, compute the remainder
        // and add k-remainder value hash count to ans
        for (int i = 0; i < n; i++)
        {
            int rem = A[i] % K;
            if (rem != 0)
                ans += freq[K - rem];
            else
                ans += freq[0];

            // Increment count of remainder in hash map
            freq[rem]++;
        }

        return ans;
    }
    public static void main(String[] args)
    {
        int A[] = { 2, 2, 1, 7, 5, 3 };
        int n = A.length;
        int K = 4;
        System.out.println(countKdivPairs(A, n, K));
    }
}
