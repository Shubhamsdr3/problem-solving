package leetcode75.linkedlist;

import easy.data.ListNode;

public class AddTwoNumbers {

    /**
     * T.C -> O(n)
     * S.C -> O(n)
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null && l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;

            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.addToLast(head1, 4);
        head1.addToLast(head1, 3);

        ListNode head2 = new ListNode(5);
        head1.addToLast(head2, 6);
        head1.addToLast(head2, 4);
        ListNode result = addTwoNumbers(head1, head2);
        result.printList(result);
    }
}
