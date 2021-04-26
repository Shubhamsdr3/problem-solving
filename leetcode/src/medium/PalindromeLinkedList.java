package medium;

import easy.data.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }
        if (stack.size() ==1) {
            return true;
        }
        int i = 0;
        int j = stack.size() -1;
        while (i < j) {
            if (!stack.get(i).equals(stack.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.addToLast(head, 0);
//        head.addToLast(head, 0);
//        head.addToLast(head, 1);
        System.out.println(isPalindrome(head));
    }
}
