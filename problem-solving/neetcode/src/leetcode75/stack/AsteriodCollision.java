package leetcode75.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class AsteriodCollision {

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num: asteroids) {
            if (num > 0) stack.push(num);
            else { // if num is negative.
                while (!stack.isEmpty() && stack.peek() > 0 && -num > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(num);
                } else if (stack.peek() == -num) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 10, -5 };
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}
