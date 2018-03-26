package strings;

import java.util.Stack;

/**
 * Created by gbalasubramanian on 18/11/17.
 */
public class CheckBalancedBrackets {
    public static void main(String[] args) {
        char exp[] = {'{','(',')','}','[',']'};
        System.out.println(String.valueOf(exp));
        System.out.println(checkBanlancedBrackets(String.valueOf(exp)));
    }

    static boolean checkBanlancedBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c != ')' && c != '}' && c != ']') {
                stack.push(c);
            } else {
                int count = 0;
                while (!stack.isEmpty()) {
                    char t = stack.pop();

                }
            }
        }
        return true;
    }
}
