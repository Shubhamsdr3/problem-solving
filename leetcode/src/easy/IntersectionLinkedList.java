package easy;

import easy.data.ListNode;

import java.util.Stack;

public class IntersectionLinkedList {

    // My approach
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<>();
        while (headA != null) {
            stack1.add(headA);
            headA = headA.next;
        }

        Stack<ListNode> stack2 = new Stack<>();
        while (headB != null) {
            stack2.add(headB);
            headB = headB.next;
        }
        ListNode prev = null;
        while (!stack1.isEmpty() && !stack2.empty())  {
            prev = stack1.peek();
            if (stack1.peek() == stack2.peek()) {
                return prev;
            } else {
                stack1.pop();
                stack2.pop();
            }
        }
        return prev;
    }

    // O(len1 + len2)
    private static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int len1 = length(headA);
        int len2 = length(headB);
        int d = len2 - len1;
        if (len1 > len2) {
            ListNode temp = headA;
            headA = headB;
            headB = headA;
            d = len1 - len2;
        }
        // walk through d nodes of longer list and set the pointer at the same position of the linked list.
        for (int i =0; i < d; i++) {
            headB = headB.next;
        }
        // now both the linked lists are equidistant.
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB =  headB.next;
        }
        return null;
    }

    private static int length(ListNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.next;
        }
        return count;
    }

    /**
     * The best one
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.addToLast(headA, 1);
        headA.addToLast(headA, 8);
        headA.addToLast(headA, 4);
        headA.addToLast(headA, 5);

        ListNode headB = new ListNode(5);
        headB.addToLast(headB, 0);
        headB.addToLast(headB, 1);
        headB.addToLast(headB, 8);
        headB.addToLast(headB, 4);
        headB.addToLast(headB, 5);
         System.out.println((getIntersectionNode2(headA, headB)));
    }
}
