package tree;

import tree.data.Node;

import java.util.LinkedList;
import java.util.Queue;

public class TopView {

    private static void topView(Node root) {
        Node current = root;
        while (current != null) {
            System.out.println(current.data);
            current = current.left;
        }
        current = root.right;
        while (current != null) {
            System.out.println(current.data);
            current = current.right;
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
        Node root = new Node(6);
        insert(root, 4);
        insert(root, 8);
        insert(root, 5);
        insert(root, 3);
        insert(root, 2);
        insert(root, 9);
//        traverseList(root);
        topView(root);
    }
}
