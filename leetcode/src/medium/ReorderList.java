package medium;

import easy.data.ListNode;

public class ReorderList {

    private static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }


    }

    public static void main(String[] args) {

    }
}
