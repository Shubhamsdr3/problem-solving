package linkedlist;

class SinglyLinkedList {

    SinglyLinkedListNode head;
    private SinglyLinkedListNode tail;

    SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }

}
