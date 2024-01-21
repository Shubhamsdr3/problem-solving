package problemsolving.leetcode150.linkedlist.medium;

import easy.data.ListNode;

public class RotateList {

    /**
     * Make sure if we rotate the list by full length we will get the same list.
     * so we need to have module to represent the rotation.
     * noOfRotation = len(list) % k;
     * @param head
     * @param k
     * @return
     */
    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        if (len % k == 0) return head; // no need to rotate.
        k = k % len;
        tail.next = head;
        ListNode newLastNode = findNthNode(head, len - k); // find the nth node..last node after rotation.
        head = newLastNode.next; // head will start from the rotation node.
        newLastNode.next = null; // the nth node will become the last node.
        return head;
    }

    private static ListNode findNthNode(ListNode temp, int k) {
        int count = 1;
        while (temp != null) {
            if (count == k) return temp;
            count++;
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        ListNode result = rotateRight(head, 2);
        result.printList(result);
    }
}
