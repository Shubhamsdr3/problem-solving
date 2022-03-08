package linkedlist;

import linkedlist.data.DoublyLinkedListNode;

public class DoublyLinkedListImpl {

    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private int length;

    public DoublyLinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void insertInStart(int value) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd() {

    }

    public void printList() {

    }

    public void printReverse() {

    }

    public boolean isEmpty() {
        return length == 0;
    }
}
