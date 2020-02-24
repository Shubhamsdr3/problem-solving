package linkedlist;

public class MergeLinkedList {

    /**
     * Merging two sorted list
     * @param head1
     * @param head2
     * @return
     */
    private static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode dummy;

        if (head1.data <= head2.data) {
            dummy = head1;
            head1 = head1.next;
        } else {
            dummy = head2;
            head2 = head2.next;
        }

        SinglyLinkedListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail = head1;
                head1 = head1.next;
            } else {
                tail = head2;
                head2 = head2.next;
            }
        }

        if (head1 == null) {
            tail.next = head2;
        } else {
            tail.next = head1;
        }
        return dummy;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        head1.addToLast(head1, 2);
        head1.addToLast(head1, 3);

        SinglyLinkedListNode head2 = new SinglyLinkedListNode(2);
        head2.addToLast(head2, 3);
        head2.addToLast(head2, 4);

        head1.printList(mergeLists(head1, head2));

    }
}
