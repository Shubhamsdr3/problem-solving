package easy;

public class MaximumConsecutiveArray {

    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
