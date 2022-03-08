package recursion;

import easy.data.ListNode;

import java.util.List;

public class MergeTwoSortedLists {

    // iterative approach
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
            if (list1 == null) {
                head.next = list2;
            } else if (list2 == null) {
                head.next = list1;
            }
        }
        return res.next;
    }

    /**
     * Recursive approach
     * @param list1
     * @param list2
     * @return
     */
    private static ListNode mergeTwoListRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoListRecursive(list1.next, list2);
            return list1;
        } else  {
            list2.next = mergeTwoListRecursive(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.addToLast(head1, 4);
        head1.addToLast(head1, 5);

        ListNode head2 = new ListNode(0);
        head2.addToLast(head2, 1);
        head2.addToLast(head2, 3);
        ListNode res = mergeTwoListRecursive(head1, head2);
        res.printList(res);
    }
}
