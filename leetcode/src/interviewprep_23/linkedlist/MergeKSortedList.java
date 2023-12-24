package interviewprep_23.linkedlist;

import easy.data.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    /**
     * Using Priority Queue.
     * T.C -> N(logk)
     * S.C. -> O(k)
     * @param lists
     * @return
     */
    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // will store the list in sorted way
        for (ListNode node: lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    private  static ListNode mergeKListUsingTwoList(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);
        return mergeTwoLists(
                mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)),
                mergeKLists(Arrays.copyOfRange(lists, lists.length / 2, lists.length))
        );
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 == null ? list2 : list1;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.addToLast(list1, 4);
        list1.addToLast(list1, 5);

        ListNode list2 = new ListNode(1);
        list2.addToLast(list2, 3);
        list2.addToLast(list2, 4);

        ListNode list3 = new ListNode(2);
        list3.addToLast(list3, 6);

        ListNode[] nodes = new ListNode[] {
                list1, list2, list3
        };

        ListNode result = mergeKListUsingTwoList(nodes);
        result.printList(result);
    }
}
