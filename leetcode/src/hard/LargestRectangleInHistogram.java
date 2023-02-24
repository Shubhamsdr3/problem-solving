package hard;

import java.util.Stack;

/**
Created at: 22/01/23
*/
public class LargestRectangleInHistogram {

    public static int largestRectangleAreaUsingStack(int[] heights) {
        int size = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[size];
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) leftSmaller[i] = 0;
            else leftSmaller[i] = stack.peek() + 1;
            stack.push(i);
        }
        stack.clear(); // to reuse the same stack

        int[] rightSmaller = new int[size];
        for (int i = size -1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) rightSmaller[i] = size - 1;
            else rightSmaller[i] = stack.peek() - 1;
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i] - leftSmaller[i] + 1));
        }
        return maxArea;
    }

    /**
     * T.C -> O(n^2)
     * @param heights
     * @return
     */
    private static int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleAreaUsingStack(arr));
        System.out.println(largestRectangleArea(arr));

        int[] arr1 = new int[] {2, 4};
        System.out.println(largestRectangleAreaUsingStack(arr1));
        System.out.println(largestRectangleArea(arr1));

        int[] arr2 = new int[] {1, 1};
        System.out.println(largestRectangleAreaUsingStack(arr2));
        System.out.println(largestRectangleArea(arr2));
    }
}
