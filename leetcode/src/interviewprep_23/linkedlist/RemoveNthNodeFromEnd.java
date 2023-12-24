package interviewprep_23.linkedlist;

import easy.data.ListNode;

public class RemoveNthNodeFromEnd {

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0); // dummy node
        ListNode slow = start;
        ListNode fast = start;
        start.next = head;

        // move fast in front so that the gap b/w slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        // move fast to the end.
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // skip the desired node.
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head,2);
        head.addToLast(head,3);
        head.addToLast(head,4);
        head.addToLast(head,5);
        int n = 2;
        ListNode res = removeNthFromEnd(head, n);
        res.printList(res);
    }
}
