package medium;

import easy.data.ListNode;

import java.util.Stack;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.addToLast(head1, 4);
        head1.addToLast(head1, 3);

        ListNode head2 = new ListNode(5);
        head2.addToLast(head2, 6);
        head2.addToLast(head2, 4);
        ListNode resultHead = addTwoNumbers(head1, head2);
        resultHead.printList(resultHead);
    }
}
