package general;

/**
 * Created by gbalasubramanian on 02/01/19.
 */
public class PowerOfNumber {
    public static void main(String[] args) {
        System.out.println(power(3,4));
    }

    static int power(int x, int y) {
        int temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }
}
