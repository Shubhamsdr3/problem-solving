package linkedlist;

public class InsertNodeAtEnd {

    static class SinglyLinkedListNode {

        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {

        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }
    }
    private static void printSinglyLinkedList(SinglyLinkedListNode node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
        temp.next = null;
        if(head == null) {
            head = temp;
        } else {
            SinglyLinkedListNode current = head;
            while(current.next != null) {
                current = current.next;
                current.next = temp;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        int numberOfItems = 5;

        int[] items = new int[]{141, 302, 164, 530, 474};
        for (int i = 0; i < items.length; i++) {
            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, items[i]);
            llist.head = llist_head;
        }

        printSinglyLinkedList(llist.head);
    }
}
