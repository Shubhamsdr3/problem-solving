package easy;

import easy.data.NAryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {

    private static List<Integer> preorder(NAryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    private static void preorderTraversal(NAryTreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (NAryTreeNode child: root.children) {
            preorderTraversal(child, list);
        }
    }

    public static void main(String[] args) {
        NAryTreeNode root = new NAryTreeNode(1);
        root.children.add(new NAryTreeNode(3));
        root.children.add(new NAryTreeNode(2));
        root.children.add(new NAryTreeNode(4));
        root.children.get(0).children.add(new NAryTreeNode(5));
        root.children.get(0).children.add(new NAryTreeNode(6));
        System.out.println(preorder(root));
    }
}
