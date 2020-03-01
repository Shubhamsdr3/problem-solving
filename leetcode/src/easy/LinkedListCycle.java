package easy;

import easy.data.ListNode;

import java.util.List;

public class LinkedListCycle {

    // Rabbit and turtle technique
    private static boolean hasCycle(ListNode head) {
        if (head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.addToLast(head,2);
        head.addToLast(head,0);
        head.addToLast(head,-4);
        System.out.println(hasCycle(head));
    }
}
