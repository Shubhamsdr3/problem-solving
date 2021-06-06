package easy;

import easy.data.ListNode;

public class DeleteNodeLinkedList {

    private static void deleteNode(ListNode node) {

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.addToLast(head, 5);
        head.addToLast(head, 1);
        head.addToLast(head, 9);
    }
}
