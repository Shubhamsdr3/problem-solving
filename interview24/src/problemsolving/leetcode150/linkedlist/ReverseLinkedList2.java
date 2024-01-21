package problemsolving.leetcode150.linkedlist;

import easy.data.ListNode;

public class ReverseLinkedList2 {

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPre = dummy;
        ListNode currNode = head;

        for (int i = 1; i < left; i++) {
            leftPre = leftPre.next;
            currNode = currNode.next;
        }

        ListNode sublistHead = currNode;

        ListNode preNode = null;

        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = preNode;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        leftPre.next = preNode;
        sublistHead.next = currNode;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
