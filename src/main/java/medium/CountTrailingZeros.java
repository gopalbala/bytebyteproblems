package medium;

/**
 * Created by gbalasubramanian on 20/11/17.
 */
public class CountTrailingZeros {
    public static void main(String[] args) {
        System.out.println(countFActorialZeros(25));
    }
    static int countFActorialZeros(int num){
        int count = 0;
        if (num < 0)
            return -1;
        for (int i=5;num/i >0;i*=5){
            count += num /i;
        }
        return count;
    }
}
