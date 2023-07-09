package medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class JumpGameIII {

    /**
     * i -> i + arr[i]
     * i -> i - arr[i]
     * @param arr
     * @param start
     * @return
     */
    private static boolean canReach(int[] arr, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        Set<Integer> seen = new HashSet<>();
        seen.add(start);
        while (!stack.isEmpty()) {
            int position = stack.pop();
            // check if you have already reached there.
            if (arr[position] == 0) {
                return true;
            }
            // check it's left and right child
            int left = position - arr[position];
            int right = position + arr[position];
            // check it's left is valid and not in our hashset to avoid cycles.
            if (left >= 0 && left < arr.length && !seen.contains(left)) {
                seen.add(left);
                stack.push(left);
            }
            // check it's right is valid and not in our hashset to avoid cycles.
            if (right >= 0 && right < arr.length && !seen.contains(right)) {
                seen.add(right);
                stack.push(right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(canReach(arr, start));
    }
}
