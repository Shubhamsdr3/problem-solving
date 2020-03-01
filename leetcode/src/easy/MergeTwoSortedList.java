package easy;

import easy.data.ListNode;

public class MergeTwoSortedList {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummyNode.addToLast(dummyNode, l1.val);
                dummyNode.addToLast(dummyNode, l2.val);
            } else {
                dummyNode.addToLast(dummyNode, l2.val);
                dummyNode.addToLast(dummyNode, l1.val);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummyNode.next;
    }

    private static void printList(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null) {
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
//        head1.addToLast(head1, 1);
//        head1.addToLast(head1, 4);

        ListNode head2 = new ListNode(1);
//        head2.addToLast(head2, 3);
//        head2.addToLast(head2, 4);
        printList(mergeTwoLists1(head1, head2));
    }
}
