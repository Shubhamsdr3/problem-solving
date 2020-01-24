package linkedlist;

public class ReverseLinkedList {

    /**
     * tO print the reverse linked list
     * using recursion without reversing it
     * @param head
     */
    private static void reversePrint(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next); // #TheCatchIsThis
        System.out.println(head.data+" ");
    }

    private static void printSinglyLinkedList(SinglyLinkedListNode node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.println();
            }
        }
    }

    /**
     * To reverse a linked list we need two pointer
     * 1. To store the variable of next node
     * 2. To store the variable of previous node
     * @param head
     * @return
     */
    private static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode current  = head; // initially current node is head.
        SinglyLinkedListNode prevNode = null;
        SinglyLinkedListNode nextNode;
        while (current != null) {
            // head(fist node) is set to null.
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        head = prevNode;
        return head;
    }

    public static void main(String[] args) {
        int[] items = new int[]{16, 12, 4, 2, 5};
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int val: items) {
            singlyLinkedList.insertNode(val);
        }
//        printSinglyLinkedList(singlyLinkedList.head);
        reversePrint(singlyLinkedList.head);
    }
}
