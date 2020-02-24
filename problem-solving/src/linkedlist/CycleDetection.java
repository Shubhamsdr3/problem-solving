package linkedlist;

public class CycleDetection {

    // Timeout
    private static boolean hasCycle(SinglyLinkedListNode head) {
        if (head.next == null) {
            return false;
        }
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = head;

        while (current != null) {
            if (prev != null && current.next == prev) {
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    //with tortoise and the hare technique(fast and slow pointer) Optimized one.
    private static boolean hasCycle1(SinglyLinkedListNode head) {
        if (head.next == null) {
            return false;
        }
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 2);
//        head.addToLast(head, 5);
//        head.printList(head);
        System.out.println(hasCycle(head));
    }
}
