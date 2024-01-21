package problemsolving.leetcode75.binarytree;

import easy.data.ListNode;
import easy.data.TreeNode;

public class ConvertSortedArrayToBST {

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBst(head, null);
    }

    private static TreeNode toBst(ListNode head, ListNode prev) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == prev) return null; // base case.
        while (fast != prev && fast.next != prev) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBst(head, slow);
        root.right = toBst(slow.next, prev);
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.addToLast(head, -3);
        head.addToLast(head, 0);
        head.addToLast(head, 5);
        head.addToLast(head, 9);
        TreeNode root = sortedListToBST(head);
        root.postOrder(root);
    }
}
