package linkedlist;

public class SinglyLinkedListNode {

    public int data;

    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    SinglyLinkedListNode addToLast(SinglyLinkedListNode head, int val) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(val);

        // if there is no node
        if (head == null) {
            head =  newNode;
            return head;
        }

        // to be sure that this will be the last element
        newNode.next = null;

        SinglyLinkedListNode last = head;
        // go to the end of the list
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return newNode;
    }

    public void printList(SinglyLinkedListNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

}
