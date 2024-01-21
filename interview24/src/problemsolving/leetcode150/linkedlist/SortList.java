package problemsolving.leetcode150.linkedlist;

import easy.data.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    /**
     * Get the middle of linked list and
     * then sort them using merge sort.
     *
     * 1. Slow-fast pointer.
     * 2. recursion.
     * 3. Divide and conquer.
     * @param head
     * @return
     */
    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next; // found the mid-point.
        slow.next = null;

        // divide and get sorted lists.
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        ListNode ans = new ListNode(-1); // dummy node.
        ListNode last = ans;

        // merge 2 lists.
        while (left != null || right != null) {
            int n1 = left != null ? left.val : Integer.MAX_VALUE;
            int n2 = right != null ? right.val : Integer.MAX_VALUE;

            if (n1 < n2) {
                last.next = left;
                left = left.next;
            } else {
                last.next = right;
                right = right.next;
            }
            last = last.next;
        }
        return ans.next;
    }

    private static ListNode sortList1(ListNode head) {
        return mergeSort(head);
    }

    /**
     * Using brute force.
     * T.C -> O(n)
     * S.C -> O(n)
     * @param node
     * @return
     */
    private static ListNode sortList(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int val: list) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.addToLast(head, 2);
        head.addToLast(head, 1);
        head.addToLast(head, 3);
        ListNode result = sortList1(head);
        result.printList(head);
    }
}
