package easy;

import easy.data.ListNode;

import java.util.Stack;

public class ConvertBinaryNumberLinkedListInteger {

    private static int getDecimalValue(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            stack.add(current.val);
            current = current.next;
        }
        int sum = 0;
        int index = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == 1) {
                sum = sum + (int)Math.pow(2, index);
            }
            index++;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
//        root.addToLast(root,0);
//        root.addToLast(root,1);
        int[] arr = new int[]{0,0,1,0,0,1,1,1,0,0,0,0,0,0};
        for (int item: arr) {
            root.addToLast(root, item);
        }
        System.out.println(getDecimalValue(root));
    }
}
