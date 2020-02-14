package easy;

public class DeleteDuplicates {

    /**
     * delete only duplicate number
     * @param head
     * @return
     */
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * deleting all the node which has duplicate elements
     * @return : head node
     */
    private static ListNode deleteAllNodeWithDuplicate(ListNode head) {
        ListNode current = head;
        ListNode dummy = new ListNode(0); //TODO: THE-CATCH
        dummy.next = head;
        ListNode prev = dummy;

        while (current != null ) {
            while (current.next != null && current.val == current.next.val) {
                // jab tak equal hai...
                current = current.next;
            }

            if (prev.next == current) {
                prev = prev.next;
            } else {
                prev.next = current.next;
            }

            current = current.next;
        }
        return dummy.next; // so that 0 don't get print if all above fails
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
//        head.addToLast(head, 4);
//        head.addToLast(head, 4);
//        head.addToLast(head, 5);

        printList(deleteAllNodeWithDuplicate(head));

//        System.out.println(deleteDuplicates(head).val);
    }
}
