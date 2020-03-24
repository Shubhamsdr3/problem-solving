package easy;

import java.util.Arrays;

public class RelativeRank {

    private static String[] findRelativeRanks(int[] nums) {
        String[] arr = new String[nums.length];
        Arrays.sort(nums);
        arr[0] = "Gold Medal";
        arr[1] = "Silver Medal";
        arr[2] = "Bronze Medal";
        for (int i =3; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
}
