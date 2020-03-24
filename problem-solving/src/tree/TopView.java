package tree;

import tree.data.Node;

import java.util.LinkedList;
import java.util.Queue;

public class TopView {

    private static void topView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current =  queue.poll();
            System.out.println(current.data);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    private static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    private static void traverseList(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        traverseList(root.left);
        traverseList(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        insert(root, 2);
        insert(root, 5);
        insert(root, 6);
        insert(root, 3);
        insert(root, 4);
//        traverseList(root);
        topView(root);
    }
}
