package medium;

import java.util.Arrays;

public class MinimumMovesElements2 {

    private static int minMoves2(int[] nums) {
        int moves = Integer.MAX_VALUE;
        for (int num : nums) {
            int count = 0;
            for (int j : nums) {
                if (j != num) {
                    count = count + Math.abs(j - num);
                }
            }
            moves = Math.min(count, moves);
        }
        return moves;
    }

    private static int minMoves3(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length -1;
        int count = 0;
        while (i < j) {
            count = count + nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143};
        System.out.println(minMoves3(input));
    }
}
