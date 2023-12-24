package interviewprep_23.linkedlist;

import easy.data.ListNode;

import java.util.LinkedList;
import java.util.List;

public class PalindromeLinkedList {

    /**
     * Using Floyd cycle detection.
     *
     * @param head
     * @return
     */
    private static boolean isPalindromeUsingReverse(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse
        ListNode prev = slow;
        ListNode temp;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * T.C -> O(n)
     * S.C -> O(n)
     * @param head
     * @return
     */
    private static boolean isPalindrome(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start) != list.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
//        head.addToLast(head, 2);
//        head.addToLast(head, 1);
        System.out.println(isPalindromeUsingReverse(head));
    }
}
