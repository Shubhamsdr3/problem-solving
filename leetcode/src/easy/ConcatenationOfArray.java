package easy;

import java.util.Arrays;

public class ConcatenationOfArray {

    private static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int index = 0;
        for (int num : nums) {
            ans[index] = num;
            index++;
        }
        for (int num : nums) {
            ans[index] = num;
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,1};
        System.out.println(Arrays.toString(getConcatenation(arr)));
    }
}
