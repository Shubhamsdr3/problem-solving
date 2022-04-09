package medium;

import easy.data.ListNode;

public class PartitionList {

    private static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode temp = head;
        ListNode res = dummy;
        while (temp != null) {
            if (temp.val < x) {
                dummy.next = new ListNode(temp.val);
                dummy = dummy.next;
            }
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val >= x) {
                dummy.next = new ListNode(temp.val);
                dummy = dummy.next;
            }
            temp = temp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.addToLast(head, 1);
        ListNode res = partition(head, 2);
        res.printList(res);
    }
}