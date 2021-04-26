package medium;

import easy.data.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        int i = list1.size() -1;
        int j = list2.size() -1;
        return l1;
    }

    public static void main(String[] args) {

    }
}
