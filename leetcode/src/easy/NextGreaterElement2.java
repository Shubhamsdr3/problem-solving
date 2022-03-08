package easy;

import java.util.Arrays;
import java.util.Stack;
/**
Created at: 04/02/22
*/
public class NextGreaterElement2 {

    private static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int[] result = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.peek() < num) {
                result[index] = num;
                stack.pop();
                index++;
            }
            stack.push(num);
        }
        System.out.println(stack);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
}
