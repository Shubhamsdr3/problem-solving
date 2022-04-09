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
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        if (count <= n) {
            return null;
        }
        int position = count - n;
        ListNode prev = head;
        ListNode temp = head;
        int index = 0;
        while (index < position) {
            prev = temp;
            temp = temp.next;
            index++;
        }
        prev.next = temp.next;
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
        ListNode res = removeNthFromEnd(head, 1);
        res.printList(res);
    }
}
