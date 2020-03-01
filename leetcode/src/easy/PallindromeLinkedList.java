package easy;

import easy.data.ListNode;

import java.util.*;

public class PallindromeLinkedList {

    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int i = 0;
        int j = list.size()-1;

        while (i < list.size() && j >=0) {
            if (list.get(i).val != list.get(j).val) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.addToLast(head, 0);
        System.out.println(isPalindrome(head));
    }
}
