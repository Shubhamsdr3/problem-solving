package easy;

import easy.data.TreeNode;

import java.util.*;

public class ModeInBST {

    //FIXME:SHUBHAM
    private static int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode current = queue.poll();
                map.put(current.val, map.getOrDefault(current.val, 0)+1);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                size--;
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        List<Integer> resultList = new ArrayList<>();
        resultList.add(list.get(0).getKey());
        for (int i=1; i < list.size(); i++) {
            if (list.get(i-1).getValue().equals(list.get(i).getValue())) {
                resultList.add(list.get(i).getKey());
            } else  {
                break;
            }
        }
        int[] result = new int[resultList.size()];
        for (int i =0; i< resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(Arrays.toString(findMode(root)));
    }
}
