package easy.data;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode addToLast(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        // if there is no node
        if (head == null) {
            head =  newNode;
            return head;
        }

        // to be sure that this will be the last element
        newNode.next = null;

        ListNode last = head;
        // go to the end of the list
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        return newNode;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
