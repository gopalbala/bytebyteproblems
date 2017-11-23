package strings;

import java.util.Scanner;

/**
 * Created by fax6 on 22/11/17.
 */
public class PermutationPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int bitVector = createBitVector(input);
        System.out.println( bitVector == 0 || checkExactlyOneBitSet(bitVector));
    }

    static int createBitVector(String input) {
        int bitVector = 0;
        for (char c : input.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0) {
            return bitVector;
        }
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector = bitVector | mask;
        } else {
            bitVector = bitVector & ~mask;
        }
        return bitVector;
    }

    static boolean checkExactlyOneBitSet(int bitVector){
        return (bitVector & (bitVector-1)) == 0;
    }
    static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
}
