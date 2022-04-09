package medium;

import easy.data.ListNode;

/**
Created at: 21/03/22
*/
public class RotateList {

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        tail.next = head;
        int newIndex = count - k % count;
        for (int i = 0; i < newIndex; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.addToLast(head, 1);
        head.addToLast(head, 2);
        ListNode res = rotateRight(head, 1);
        res.printList(res);
    }
}
