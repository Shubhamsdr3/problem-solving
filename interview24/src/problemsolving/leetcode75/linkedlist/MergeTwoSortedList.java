package problemsolving.leetcode75.linkedlist;


import easy.data.ListNode;

public class MergeTwoSortedList {

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode result = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummyHead.next = new ListNode(list1.val);
                list1 = list1.next;
            } else  {
                dummyHead.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            dummyHead = dummyHead.next;
        }
        while (list1 != null) {
            dummyHead.next = new ListNode(list1.val);
            dummyHead = dummyHead.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            dummyHead.next = new ListNode(list2.val);
            dummyHead = dummyHead.next;
            list2 = list2.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.addToLast(head1, 2);
        head1.addToLast(head1, 4);

        ListNode head2 = new ListNode(1);
        head2.addToLast(head2, 3);
        head2.addToLast(head2, 4);

        ListNode result = mergeTwoLists(head1, head2);
        result.printList(result);
    }
}
