package medium;

import easy.data.ListNode;

public class ReverseLinkedListII {

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = null;
        int position = 1;
        while (head != null) {
            ListNode next =  head.next;
            if (position ==  m && position <= n ) {
                head.next = newHead;
                newHead =  head;
                head = next;
            }
            position++;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        ListNode res = reverseBetween(head, 2, 4);
        res.printList(res);
    }
}
