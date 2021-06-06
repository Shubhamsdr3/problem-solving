package medium;

import easy.data.ListNode;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class PalindromeLinkedList {

    private static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // for odd nodes
            slow = slow.next;
        }
        slow = reverse(slow);
        ListNode dummy = head;
        while (slow != null) {
            if (slow.val != dummy.val) {
                return false;
            }
            slow = slow.next;
            dummy = dummy.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 3);
        head.addToLast(head, 2);
        head.addToLast(head, 1);
        System.out.println(isPalindrome(head));
    }
}
