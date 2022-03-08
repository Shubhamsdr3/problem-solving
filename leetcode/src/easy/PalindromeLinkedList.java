package easy;

import easy.data.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    private static boolean isPalindrome(ListNode head) {
        Stack<Integer> list = new Stack<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() == 1) {
            return true;
        }
        int start =0;
        int end = list.size() -1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 1);
        System.out.println(isPalindrome(head));
    }
}
