package easy;

public class RemoveLinkedListElement {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // recursive approach
    private ListNode removeElements(ListNode head, int val) {
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

    public static void main(String[] args) {

    }
}
