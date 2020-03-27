package com.gb.bytebybyteproblems;

/**
 * Created by gbalasubramanian on 23/08/17.
 */
public class ConvertToRoman {
    public static void main(String[] args) {
        int number = 49;//1231;
        String romanNumber = convertToRoman(number);
        System.out.println(String.format("Roman Number equivalent of %d is %s",number,romanNumber));
    }

    private static String convertToRoman(int number) {
        String[] numerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        if (number > 3999 && number < 1) {
            return "";
        }
        String output = "";
        int i = 0;
        while (number > 0) {
            if (number - values[i] >= 0) {
                output = output + numerals[i];
                number = number - values[i];
            } else {
                i++;
            }
        }
        return output;
    }
}
