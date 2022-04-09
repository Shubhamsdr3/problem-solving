package easy;

import easy.data.ListNode;

public class RemoveDuplicatesFromSortedList1 {

    /**
     * TODO
     * @param head
     * @return
     */
    private static ListNode deleteDuplicates(ListNode head) {
       ListNode current = head;
       while (current != null) {
           while (current.next != null && current.val == current.next.val) {
               current.next = current.next.next;
           }
           current = current.next;
       }
       return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 1);
        head.addToLast(head, 2);
        ListNode res = deleteDuplicates(head);
        res.printList(res);
    }
}
