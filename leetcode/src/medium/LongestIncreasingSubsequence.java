package medium;

import java.util.Stack;

public class LongestIncreasingSubsequence {

    private static int lengthOfLIS(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
            for (int j = i+1; !stack.isEmpty() && j < nums.length; j++) {
                int current = stack.peek();
                if (nums[j] > current) {
                    stack.push(nums[j]);
                } else {
                    stack.pop();
                }
            }
        }
        for (int val : stack){
            System.out.print(val + " ");
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 10,9,2,5,3,7,101,18 };
        System.out.println(lengthOfLIS(arr));
    }
}
