package easy;

import easy.data.ListNode;

public class RemoveLinkedListElement {

    // recursive approach
    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode next = removeElements(head.next, val);
        if(head.val == val){
            return next;
        }
        head.next = next;
        return head;
    }

    /**
     * Iterative approach
     * @param head
     * @param val
     * @return
     */
    private static ListNode removeElementsIterative(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = null;
        ListNode node = dummy;
        while (node != null) {
            if (prev != null && node.val == val) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.addToLast(head, 7);
        head.addToLast(head, 7);
        head.addToLast(head, 7);
        ListNode resHead = removeElementsIterative(head, 7);
        resHead.printList(resHead);
    }
}
