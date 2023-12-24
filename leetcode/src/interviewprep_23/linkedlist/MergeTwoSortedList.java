package interviewprep_23.linkedlist;

import easy.data.ListNode;

public class MergeTwoSortedList {

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 == null ? list2 : list1;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.addToLast(list1, 2);
        list1.addToLast(list1, 4);

        ListNode list2 = new ListNode(1);
        list2.addToLast(list2, 3);
        list2.addToLast(list2, 4);

        ListNode res = mergeTwoLists(list1, list2);
        res.printList(res);
    }
}
