package easy;

public class HouseRobber {

    private static int rob(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int totalMoney = 0;
        int i = 0;
        while (i < nums.length-1) {
            if (nums[i] < nums[i+1] && nums[i+1] > nums[i+2]) {
                totalMoney = totalMoney + nums[i+1];
            } else {
                totalMoney = totalMoney + nums[i];
            }
            i = i+2;
        }
        if (nums.length % 2 == 0 && i == nums.length -1) {
            totalMoney = totalMoney + nums[nums.length -1];
        }
        return totalMoney;
    }

    /**
     * Using DP.
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        return rob1(nums, nums.length - 1);
    }
    private int rob1(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob1(nums, i - 2) + nums[i], rob1(nums, i - 1));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,9,3,1};
        System.out.println(rob(arr));
    }
}
