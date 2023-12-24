package interviewprep_23.linkedlist;

import easy.data.ListNode;

public class LinkedListCycle {

    /**
     * T.C -> O(n)
     * @param head
     * @return
     */
    private static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = head.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.addToLast(head, 2);
        head.addToLast(head, 0);
        head.addToLast(head, -4);
        System.out.println(hasCycle(head));
    }
}
