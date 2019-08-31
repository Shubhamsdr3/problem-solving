public class LinkedList {

    private Node head;
    private Node next;

    public LinkedList(Node head, Node next) {
        this.head = head;
        this.next = next;
    }

    public Node getHead() {
        return head;
    }

    public Node getNext() {
        return next;
    }
}
