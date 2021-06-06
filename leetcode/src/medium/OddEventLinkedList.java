package medium;

import easy.data.ListNode;

public class OddEventLinkedList {

    private static ListNode oddEvenList(ListNode head) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        ListNode oddCurrent = head;
        int oddIndex = 1;
//        while (oddCurrent != null) {
//            if (oddIndex % 2 != 0) {
//                temp.next = oddCurrent;
//                temp = temp.next;
//            }
//            oddCurrent = oddCurrent.next;
//            oddIndex++;
//        }

        ListNode evenCurrent = oddCurrent;
        int evenIndex = 2;
        while (evenCurrent != null) {
            if (evenIndex % 2 == 0) {
                temp.next = evenCurrent;
                temp = temp.next;
            }
            evenCurrent = evenCurrent.next;
            evenIndex++;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        ListNode result = oddEvenList(head);
        result.printList(result);
    }
}
