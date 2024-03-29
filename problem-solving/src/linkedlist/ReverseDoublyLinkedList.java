package linkedlist;

import linkedlist.data.DoublyLinkedListNode;

public class ReverseDoublyLinkedList {

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        DoublyLinkedListNode newHead = head;
        while (temp != null) {
            DoublyLinkedListNode prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            newHead = temp;
            temp = temp.prev;
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}
