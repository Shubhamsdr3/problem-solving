package tree.problems;

import tree.TreeNode;

public class HuffmanCoding {

    private static void decode(String s, TreeNode root) {
        StringBuilder decodedString = new StringBuilder();
        TreeNode currentNode = root;
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '0') {
                currentNode = root.left;
            } else {
                currentNode = root.right;
            }
            if (currentNode.left == null && currentNode.right == null) {
                decodedString.append(currentNode.data);
                currentNode = root;
            }
        }
        System.out.println(decodedString);
    }

    void decode1(String S, TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode c = root;

        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i) == '1' ? c.right : c.left;
            if ( c.left == null && c.right == null) {
                sb.append(c.data);
                c = root;
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
//        String s = "1001011";
//        decode(s, new TreeNode());
    }
}
