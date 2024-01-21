package leetcode75.linkedlist;

import easy.data.ListNode;

public class OddEvenLinkedList {

    /**
     * Odd -> next => even
     * Even-> next => Odd.
     * @param head
     * @return
     */
    private static ListNode oddEvenList(ListNode head) {
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode oddEven = head.next;

        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = evenNode.next; // odd -> next => even -> next
            evenNode.next = oddNode.next.next; // even -> next => even-> next -> next

            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = oddEven;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        ListNode res = oddEvenList(head);
        res.printList(res);
    }
}
