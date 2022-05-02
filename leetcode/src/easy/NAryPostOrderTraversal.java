package easy;

import easy.data.NAryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class NAryPostOrderTraversal {

    private static List<Integer> postorder(NAryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    private static void postorderTraversal(NAryTreeNode root, List<Integer> list) {
        if (root == null) return;
        for (NAryTreeNode child: root.children) {
            postorderTraversal(child, list);
        }
        list.add(root.val);
    }

    public static void main(String[] args) {
        NAryTreeNode root = new NAryTreeNode(1);
        root.children.add(new NAryTreeNode(3));
        root.children.add(new NAryTreeNode(2));
        root.children.add(new NAryTreeNode(4));
        root.children.get(0).children.add(new NAryTreeNode(5));
        root.children.get(0).children.add(new NAryTreeNode(6));
        System.out.println(postorder(root));
    }
}
