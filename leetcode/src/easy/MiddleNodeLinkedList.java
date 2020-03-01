package easy;

public class MiddleNodeLinkedList {

    private static class ListNode  {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        private ListNode addToLast(ListNode head, int val) {
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

        private void printList(ListNode head) {
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }
    }

    private ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        int count = 0;
        while (head != null) {
            count++;
            if (count % 2 == 0 ) {
                if (count == count / 2 + 1) {
                    return head.next;
                }
            } else if (count == count / 2) {
                return head.next;
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MiddleNodeLinkedList linkedList = new MiddleNodeLinkedList();
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
//        head.printList(head);

        System.out.println(linkedList.middleNode(head).val);
    }
}
