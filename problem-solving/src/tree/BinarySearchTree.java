package tree;

import tree.data.Node;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private static boolean checkBST(Node root) {
        List<Integer> list = new ArrayList<>();
        getInorderList(root, list);
        for (int i= list.size() -1; i > 0; i--) {
            if (list.get(i) < list.get(i -1)) {
                return false;
            }
        }
        return true;
    }

    private static void getInorderList(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        getInorderList(root.left, list);
        list.add(root.data);
        getInorderList(root.right, list);
    }

    public static void main(String[] args) {
        Node root = new Node(3);

    }
}
