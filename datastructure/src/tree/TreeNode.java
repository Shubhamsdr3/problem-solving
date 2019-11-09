package tree;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * Duplicate values are not allowed.
     * @param value : To insert.
     */
    public void insert(int value) {
        if (value == data) {
            //Duplicate value
            return;
        }
        if (value < data) {
            if (left == null) {
                left = new TreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new TreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    void traverseInorder() {
        if (left != null) {
            left.traverseInorder();
        }
        System.out.println("Data: -> " + data + ", ");
        if (right != null) {
            right.traverseInorder();
        }
    }

    void traversePreOrder() {
        System.out.println("Data: -> " + data + ", ");
        if (left != null) {
            left.traversePreOrder();
        }
        if (right != null) {
            right.traversePreOrder();
        }
    }

    void traversePostOrder() {
        if (left != null) {
            left.traversePostOrder();
        }
        if (right != null) {
            right.traversePostOrder();
        }
        System.out.println("Data: -> " + data + ", ");
    }

    TreeNode get(int value) {
        if (value == data) {
            return this;
        }

        if (value < data) {
            return left.get(value);
        } else {
            return right.get(value);
        }
    }


    /**
     * The alternative method of find minimum.
     * @return : the minimum value of the tree.
     */
    int getMinimum() {
        if (left == null){
            return data;
        } else {
            return left.getMinimum();
        }
    }

    int getMaximum() {
        if (right == null){
            return data;
        } else {
            return right.getMaximum();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
