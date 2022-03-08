package easy;

public class LongestContinuousIncreasing {

    public static int findLengthOfLCIS(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 1;
        int start = 0;
        while (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] < nums[i + 1]) {
                    if (i == nums.length -1 && nums[i] < nums[nums.length -1]) {
                        count++;
                    }
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                    break;
                }
            }
            start++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4, 7};
        System.out.println(findLengthOfLCIS(arr));
    }
}
