package array;

import java.util.Stack;

/**
 * Created by gbalasubramanian on 14/10/18.
 */
public class NextGreaterElement {
    private static  void printNGE()
    {
        int arr[] = {11, 13, 21, 3};
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[arr.length];

        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--) {

               /* if stack is not empty, then
            pop an element from stack.
            If the popped element is smaller
            than next, then
            a) print the pair
            b) keep popping while elements are
            smaller and stack is not empty */
            if (!s.empty()) {
                while (!s.empty() && s.peek() <= arr[i]) {
                    s.pop();
                }
            }
            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);

        }
        for(int i = 0; i < arr.length; i++)
            System.out.print(nge[i] + " ");
    }
    public static void main(String[] args) {
        printNGE();
    }
}
