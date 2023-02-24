package medium;

import easy.data.ListNode;

public class ReverseLinkedList {

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = null;
        int position = 1;
        while (head != null) {
            ListNode next =  head.next;
            if (position == m && position <= n ) {
                head.next = newHead;
                newHead =  head;
                head = next;
            }
            position++;
        }
        return newHead;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 4;
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        printList(reverseBetween(head, m, n));
    }
}
