package easy;

import easy.data.NAryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfNAryTree {

    private static int maxDepth(NAryTreeNode root) {
        if (root == null) return 0;
        Queue<NAryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NAryTreeNode current = queue.poll();
                for (NAryTreeNode child: current.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        NAryTreeNode root = new NAryTreeNode(1);
        root.children.add(new NAryTreeNode(3));
        root.children.add(new NAryTreeNode(2));
        root.children.add(new NAryTreeNode(4));
        root.children.get(0).children.add(new NAryTreeNode(5));
        root.children.get(0).children.add(new NAryTreeNode(6));
        System.out.println(maxDepth(root));
    }
}
