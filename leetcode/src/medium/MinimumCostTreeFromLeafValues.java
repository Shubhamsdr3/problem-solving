package medium;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {

    private static int mctFromLeafValues(int[] arr) {
       int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int num: arr) {
            while (stack.peek() <= num) {
                int mid = stack.pop();
                res = res + mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        while (stack.size() > 2) {
            res =  res + stack.pop() * stack.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 4};
        System.out.println(mctFromLeafValues(arr));
    }
}
