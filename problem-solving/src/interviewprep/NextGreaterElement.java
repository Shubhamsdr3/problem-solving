package interviewprep;

import java.util.Stack;

public class NextGreaterElement {

    private static void nextGreaterElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int element =  arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > element) {
                    System.out.println(element + "-->" + arr[j]);
                    break;
                }
                if (j == arr.length -1) {
                    System.out.println(element + "-->" + -1);
                }
            }
        }
    }

    /**
     * using stack
     * @param arr
     */
    private static void nextGreaterElementUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i=1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                System.out.println(stack.peek() +"-->" + arr[i]);
                stack.pop();
            }
            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4
        };
        nextGreaterElementUsingStack(arr);
    }
}
