package problemsolving.leetcode75.linkedlist;

import easy.data.ListNode;

import java.util.LinkedList;
import java.util.List;

public class MaximumTwinSumOfLinkedList {

    /**
     * With reversing from middle.
     * @param head
     * @return
     */
    private static int pairSum2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // to get the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse from the middle.
        slow = reverse(slow);
        int res = 0;
        while (slow != null) {
            res = Math.max(res, head.val + slow.val);
            head = head.next;
            slow = slow.next;
        }
        return res;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 5 -> 4 -> 2 -> 3 -> 5 -> 1 -> null
     * Pairs (5 - 1), (4, 5), (2, 3)
     * TLE
     * @param head
     * @return
     */
    private static int pairSum(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int maxValue = Integer.MIN_VALUE;
        int i = 0;
        int n = list.size();
        while (i < n) {
            int twinSum = list.get(i) + list.get(n - 1- i);
            maxValue = Math.max(twinSum, maxValue);
            i++;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.addToLast(head, 4);
        head.addToLast(head, 2);
        head.addToLast(head, 1);
        System.out.println(pairSum2(head));
    }
}
