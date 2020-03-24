package stack;

import java.util.Stack;

public class EqualStack {

    //FIXME:SHUBHAM
    private static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> stack1 = new Stack<>();
        int i = h1.length-1;
        while (i >= 0) {
            if (!stack1.isEmpty()) {
                stack1.push(stack1.peek() + h1[i]);
            } else {
                stack1.push(h1[i]);
            }
            i--;
        }

        Stack<Integer> stack2 = new Stack<>();
        int j = h2.length-1;
        while (j >= 0) {
            if (!stack2.isEmpty()) {
                stack2.push(stack2.peek() + h2[j]);
            } else {
                stack2.push(h2[j]);
            }
            j--;
        }

        Stack<Integer> stack3 = new Stack<>();
        int k = h3.length -1;
        while (k >= 0) {
            if (!stack3.isEmpty()) {
                stack3.push(stack3.peek() + h3[k]);
            } else {
                stack3.push(h3[k]);
            }
            k--;
        }

        Stack<Integer> miniStack;

        if (stack1.size() < stack2.size() && stack1.size() < stack3.size()) {
            miniStack = stack1;
        } else if (stack2.size() < stack1.size() && stack2.size() < stack3.size()) {
            miniStack = stack2;
        } else {
            miniStack = stack3;
        }

        while (!miniStack.isEmpty()) {
            if (stack2.search(miniStack.peek()) > 0 && stack3.search(miniStack.peek()) > 0) {
                return miniStack.pop();
            }
            miniStack.pop();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] h1 = new int[]{3, 2, 1, 1, 1};
        int[] h2 = new int[]{4, 3, 2};
        int[] h3 = new int[]{1, 1, 4, 1};

        int[] h4 = new int[]{1, 1, 1, 1, 1};
        int[] h5 = new int[]{3, 2};
        int[] h6 = new int[]{1, 3, 1};
        System.out.print(equalStacks(h4, h5, h6));
    }
}
