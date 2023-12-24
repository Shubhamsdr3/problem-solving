package interviewprep_23.linkedlist;

import easy.data.ListNode;

public class DeleteNodeInLinkedList {

    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
