package easy;

import easy.data.ListNode;

public class ReverseLinkedList {

    // Iterative solution
    private static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next =  head.next;
            head.next = newHead;
            newHead =  head;
            head = next;
        }
        return newHead;
    }

    /**
     * Recursive solution
     * @param head
     */
    private static ListNode reverseList1(ListNode head) {
        return reverseListInt(head, null);
    }

    private static ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null){
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.addToLast(root, 2);
        root.addToLast(root, 3);
        root.addToLast(root, 4);
        root.addToLast(root, 5);
    }
}
