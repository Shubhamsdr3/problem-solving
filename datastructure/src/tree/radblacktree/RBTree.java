package tree.radblacktree;


public class RBTree {

    private RBTreeNode rootNode;

    /**
     * There are three cases that we need to consider while inserting an element to red black tree.
     *  Let's say the new node to insert is z.
     * 1. If root is empty -> put z in root.
     * 2. If z.uncle is red -> Change the color of z.parent, z.uncle, z.grandParent
     * 3. z.uncle is black and z is left child of its parent -> Rotate z.parent to opposite direction.
     * 4. z.uncle is black and z is right child of it's parent.
     *      -> Rotate z.grandparent in opposite direction.
     *      -> Exchange colors of z.grand parent and z.parent.
     */
    private void insert(int value) {
        RBTreeNode nodeToInsert = new  RBTreeNode(value);
        nodeToInsert.setColor(ColorEnum.RED_NODE); // The new node to insert is always red color.
        if (rootNode == null) {
            // If tree is empty.
            rootNode = nodeToInsert;
            rootNode.setColor(ColorEnum.BLACK_NODE); // Change the color to black.
            nodeToInsert.setLeftChild(null);
            nodeToInsert.setRightChild(null);
            return;
        }

        RBTreeNode current = rootNode;
        if (value < current.getValue()) {
            while (current.getLeftChild() != null) {
                current = current.getLeftChild();
            }
            current = nodeToInsert;
        }


    }
}
