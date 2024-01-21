package leetcode150.linkedlist.medium;

import easy.data.ListNode;

public class PartitionList {

    /**
     * Second approach.
     * Split the list into tow sublist (smaller/bigger)
     * and then append smaller -> bigger later.
     * @param head
     * @param x
     * @return
     */
    private static ListNode partition2(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0); // save the head.
        ListNode smaller = smallerHead, bigger = biggerHead;
        while (head != null) {
            if(head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        smaller.next = biggerHead.next;
        bigger.next = null;
        return smallerHead.next;
    }

    /**
     * Naive approach.
     * T.C -> O(n)
     * S.C -> O(n)
     */
    private static ListNode partition(ListNode head, int x) {
        ListNode current = head;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (current != null) {
            if (current.val < x) {
                dummy.next = new ListNode(current.val);
                dummy = dummy.next;
            }
            current = current.next;
        }
        current = head;
        while (current != null) {
            if(current.val >= x) {
                dummy.next = new ListNode(current.val);
                dummy = dummy.next;
            }
            current = current.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 4);
        head.addToLast(head, 3);
        head.addToLast(head, 2);
        head.addToLast(head, 5);
        head.addToLast(head, 2);

        ListNode result = partition2(head, 3);
        result.printList(result);
    }
}
