package linkedlist;

public class GetNodeValue {

    /**
     *
     * @param head
     * @param positionFromTail
     * @return
     */

    private static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        int index = 0;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode result = head;
         //The catch is distance between current and result should not exceed positionFromTail
        while (current != null && current.next != null) {
            current = current.next;
            index++;
            if (index > positionFromTail) {
                result = result.next;
            }
        }
        return result.data;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
//        head.addToLast(head, 2);
//        head.addToLast(head, 7);
//        head.addToLast(head, 6);
//        head.addToLast(head, 5);
//        head.printList(head);
        System.out.println(getNode(head, 0));
    }
}
