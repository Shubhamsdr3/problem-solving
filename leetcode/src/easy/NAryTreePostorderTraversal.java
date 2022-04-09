package easy;

import easy.data.NAryTreeNode;

import java.util.*;

/**
Created at: 27/03/22
*/
public class NAryTreePostorderTraversal {

    private static List<Integer> postorder(NAryTreeNode root) {
        Stack<NAryTreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()) {
            NAryTreeNode node = stack.pop();
            list.add(node.val);
            Collections.reverse(node.children);
            for (NAryTreeNode child: node.children) {
                stack.add(child);
            }
        }
        return list;
    }

    /**
     * Level order traversal.
     * @param root
     * @return
     */
    private static List<Integer> levelOrderTraversal(NAryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<NAryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
           while (!queue.isEmpty()) {
               NAryTreeNode current = queue.poll();
               list.add(current.val);
               for (NAryTreeNode child: current.children) {
                   queue.add(child);
               }
           }
        }
        return list;
    }


    public static void main(String[] args) {
        List<NAryTreeNode> level1 = new ArrayList<>();
        level1.add(new NAryTreeNode(3));
        level1.add(new NAryTreeNode(2));
        level1.add(new NAryTreeNode(4));

        List<NAryTreeNode> level2 = new ArrayList<>();
        level2.add(new NAryTreeNode(5));
        level2.add(new NAryTreeNode(6));
        level1.get(0).children = level2;
        NAryTreeNode root = new NAryTreeNode(1, level1);
        System.out.println(levelOrderTraversal(root));
    }
}
