package tree;

public class BinarySearchTree {

    private TreeNode rootNode;

    /**
     * Note: In this implementation of tree , we don't allow duplicate elements.
     * @param value : value to insert to the tree.
     */
    public void insert(int value) {
       if (rootNode == null){
           rootNode = new TreeNode(value);
       } else {
           rootNode.insert(value);
       }
    }

    private void traverseInOrder() {
        if (rootNode != null) {
            rootNode.traverseInorder();
        }
    }

    private void traversePreOrder() {
        if (rootNode != null) {
            rootNode.traversePreOrder();
        }
    }

    private void traversePostOrder() {
        if (rootNode != null) {
            rootNode.traversePostOrder();
        }
    }

    private TreeNode get(int value) {
        if (rootNode != null) {
            return rootNode.get(value);
        }
        return null;
    }

    private int getMinimum() {
        if (rootNode == null) {
            return Integer.MIN_VALUE;
        }
        TreeNode current = rootNode;
        while (current.left != null) {
            current = current.left;
        }
        return current.getData();
    }

    private int getMaximum() {
        if (rootNode == null) {
            return Integer.MAX_VALUE;
        }
        TreeNode current = rootNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.getData();
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int height1 = getHeight(root.left);
        int height2 = getHeight(root.right);
        return 1 + Math.max(height2, height1);
    }

    private void printLevelOrderTraversal() {
        int height = getHeight(rootNode);
        // skip the root.
        for (int i=1; i<= height; i++) {
            printByGivenLevel(rootNode, i);
        }
    }

    private void printByGivenLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            // For root.
            System.out.print(root.data + " ");
        else if (level > 1) {
            printByGivenLevel(root.left, level-1);
            printByGivenLevel(root.right, level-1);
        }
    }

    /**
     * To delete a node from tree we need to consider three cases:
     * 1. When node to be deleted is leaf node.
     * 2. When the node to be deleted has one child
     * 3. When the node to be deleted has two children.
     */
    public void delete(int value) {
        rootNode =  delete(rootNode, value);
        // We want delete() to return null in case root is null at any point
        // bcoz at that time root will be the element we want to delete.(setting root -> null)
    }


    private TreeNode delete(TreeNode subTreeNode, int value) {
        if (subTreeNode == null) {
            return subTreeNode;
            // Means subtree is empty. this will make sense as we go down.
        }

        if (value < subTreeNode.getData()) {
            subTreeNode.setLeft(delete(subTreeNode.getLeft(), value));
        } else if (value > subTreeNode.getData()) {
            subTreeNode.setRight(delete(subTreeNode.getRight(), value));
        } else {
            //Case:1. When subtree has only one child
            //Case:2. subtree node is a leaf node.
            if (subTreeNode.getLeft() == null) {
                // If left child is null.
                return subTreeNode.getRight();
            } else if (subTreeNode.getRight() == null) {
                // if right is child in null.
                return subTreeNode.getLeft();
            }

            //Case:3 If node to be deleted has two children.
            // Set the node to be deleted with the replacement node.
            subTreeNode.setData(rootNode.getRight().getMinimum());

            // We can do this as well.
            // subTreeNode.setData(rootNode.getLeft().getMaximum());

            // And delete the node that has smallest value in right subtree.
            subTreeNode.setRight(delete(subTreeNode.getRight(), subTreeNode.getData()));
        }
        return subTreeNode;
    }




    public static void main(String[] args) {
        int[] inputArray = new int[]{25, 20, 15, 27, 30, 29, 26, 22, 32};
        BinarySearchTree tree = new BinarySearchTree();
        for (int value: inputArray) {
            tree.insert(value);
        }
       tree.traverseInOrder();
        System.out.println("Data we are looking for is: "  + tree.get(30).getData());
        System.out.println("The minimum we are looking for is: "  + tree.getMinimum());
        System.out.println("The Maximum we are looking for is: "  + tree.getMaximum());

        System.out.println("In order..");
        tree.traverseInOrder();

        System.out.println("Pre order..");
        tree.traversePreOrder();

        System.out.println("Post order..");
        tree.traversePostOrder();
    }
}
