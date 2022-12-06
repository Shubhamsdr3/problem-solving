package medium;

public class DecreaseElementsToMakeArrayZigzag {

    private static int movesToMakeZigzag(int[] nums) {
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = 1 ; i < nums.length; i += 2) {
            if(nums[i] >= nums[i - 1] && !(i + 1 < nums.length && nums[i - 1] > nums[i + 1]))
                curr += nums[i] - nums[i-1] + 1;
            if(i + 1 < nums.length && nums[i] >= nums[i + 1] && !(i > 0 && nums[i - 1] <= nums[i + 1]))
                curr += nums[i] - nums[i + 1] + 1;
        }
        min = Math.min(min, curr);
        curr = 0;
        for(int i = 0 ; i < nums.length; i += 2) {
            if(i > 0 && nums[i] >= nums[i - 1] && !(i + 1 < nums.length && nums[i - 1] > nums[i + 1]))
                curr += nums[i] - nums[i - 1] + 1;
            if(i + 1 < nums.length && nums[i] >= nums[i + 1] && !(i > 0 && nums[i - 1] <= nums[i + 1]))
                curr += nums[i] - nums[i + 1] + 1;
        }
        return Math.min(min, curr);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 1, 6, 2};
        System.out.println(movesToMakeZigzag(arr));
    }
}
