package medium;

import easy.data.ListNode;

/**
Created at: 18/03/22
*/
public class RemoveNthNodeFromEndOfList {

    /**
     * This is wrong.
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        return head;
    }

    private static ListNode removeNthFromEndCorrect(ListNode head, int n) {
       ListNode start = new ListNode(0);
       ListNode slow = start;
       ListNode fast = start;
       start.next = head;
       // Move the fast in front so that the gap between slow and fast becomes n
       for (int i = 1; i <= n + 1; i++) {
           fast = fast.next;
       }
       // move fast to the end , maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = removeNthFromEndCorrect(head, 2);
        res.printList(res);
    }
}
