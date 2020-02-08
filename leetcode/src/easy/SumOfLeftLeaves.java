package easy;

public class SumOfLeftLeaves {

    private static int sum = 0;
    private static TreeNode rootNode;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        void insert(Integer value) {
            if (value == val) {
                //Duplicate value
                return;
            }
            if (value < val) {
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
    }

    public void insert(Integer value) {
        if (rootNode == null){
            rootNode = new TreeNode(value);
        } else {
            rootNode.insert(value);
        }
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        TreeNode current = root;
        while(current.left != null) {
            current = current.left;
        }
        sum = sum + current.val;
        return sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
       //{3,9,20,null,null,15,7}
        SumOfLeftLeaves sum = new SumOfLeftLeaves();
        sum.insert(3);
        sum.insert(9);
        sum.insert(20);
        sum.insert(null);
        sum.insert(null);
        sum.insert(15);
        sum.insert(7);

        System.out.println(sumOfLeftLeaves(new TreeNode(3)));
    }
}
