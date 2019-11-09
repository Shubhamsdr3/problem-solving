package tree.problems;

import tree.BinarySearchTree;
import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implement the algorithm to print the element of the tree
 * by their level.
 *
 *         a       | ---L1 : a
 *     b      c    | ---L2 : b, c
 *  d     e      f | ----L3 : d, e, f
 *
 */

public class LevelOrderTraversal {


    /**
     * We will use the Queue data structure to implement the algorithm.
     * @param root : The root node of the tree.
     */
    private void printElementsByLevel(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode tempNode=queue.poll();
            System.out.print(tempNode.data+" ");
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert('b');
        tree.insert('c');
        tree.insert('d');
        tree.insert('e');
        tree.insert('f');
        tree.insert('g');
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.printElementsByLevel(new TreeNode('a'));
    }

}
