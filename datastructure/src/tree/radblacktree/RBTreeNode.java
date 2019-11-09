package tree.radblacktree;

public class RBTreeNode {

    private RBTreeNode leftChild;

    private RBTreeNode rightChild;

    private int value;

    private ColorEnum color;

    public RBTreeNode(int value) {
        this.value = value;
    }

    public RBTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RBTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public RBTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RBTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }
}
