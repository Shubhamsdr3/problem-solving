package medium;

import easy.data.NAryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
Created at: 15/04/22
*/
public class NAryTreeLevelOrderTraversal {

    private static List<List<Integer>> levelOrder(NAryTreeNode root) {
        if (root == null) return null;
        Queue<NAryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                NAryTreeNode current = queue.poll();
                currentLevel.add(current.val);
                for (NAryTreeNode node: current.children) {
                    queue.offer(node);
                }
            }
            list.add(currentLevel);
        }
        return list;
    }

    public static void main(String[] args) {
        NAryTreeNode root = new NAryTreeNode(1);
        root.children.add(new NAryTreeNode(3));
        root.children.add(new NAryTreeNode(2));
        root.children.add(new NAryTreeNode(4));
        root.children.get(0).children.add(new NAryTreeNode(5));
        root.children.get(0).children.add(new NAryTreeNode(6));
        System.out.println(levelOrder(root));
    }
}
