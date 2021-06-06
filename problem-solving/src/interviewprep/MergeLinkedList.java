package interviewprep;

import interviewprep.data.ListNode;
import tree.data.Node;

import java.awt.*;

public class MergeLinkedList {

    private  static ListNode mergeKList(ListNode[]arr, int K) {
        ListNode result = null;
        for (int i = 0; i < K; i++) {
            result = mergeList(arr[i], arr[+1]);
        }
        return result;
    }

    private static ListNode mergeList(ListNode head1, ListNode head2) {
        while (head1.next != null) {
            head1 = head1.next;
        }
        head1.next = head2;
        return head1;
    }

    public static void main(String[] args) {
        int k = 3;
        ListNode[] arr = new ListNode[k];
        ListNode head1 = new ListNode(1);
        head1.addToLast(head1, 2);
        head1.addToLast(head1, 3);
        arr[0] = head1;

        ListNode head2 = new ListNode(4);
        head1.addToLast(head1, 5);
        arr[1] = head2;

        ListNode head3 = new ListNode(6);
        head1.addToLast(head1, 7);
        arr[2] = head3;
        ListNode head = mergeKList(arr, k);
        head.printList(head);
    }
}
