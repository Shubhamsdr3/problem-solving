package linkedlist;

public class FindMergePoint {

    private static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1.next.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return 0;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        head1.addToLast(head1, 2);
        head1.addToLast(head1, 3);
        SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
        head2.addToLast(head2, 3);
        System.out.println(findMergeNode(head1, head2));
    }
}
