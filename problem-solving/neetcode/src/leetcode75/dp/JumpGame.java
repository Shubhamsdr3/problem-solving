package leetcode75.dp;

import java.util.Map;

public class JumpGame {

    private static boolean canJump(int[] nums) {
        int dis = 0;
        for (int i = 0; i <= dis; i++) {
            dis = Math.max(dis, i + nums[i]); // max distance I can jump.
            if (dis >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 1, 1, 4 };
        int[] arr1 = new int[] { 3, 2, 1, 0, 4 };
        int[] arr2 = new int[] { 0, 2, 3 };
        System.out.println(canJump(arr2)); // false
        int[] arr3 = new int[] {1, 1, 1, 0 };
        System.out.println(canJump(arr3));
        int[] arr4 = new int[] { 1, 1, 2, 2, 0, 1, 1 };
        System.out.println(canJump(arr4));
    }
}
