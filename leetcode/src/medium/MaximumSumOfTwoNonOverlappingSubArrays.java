package medium;

public class MaximumSumOfTwoNonOverlappingSubArrays {

    private static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max1 = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int n = nums.length;
        int i = 0;
        int j = i + firstLen;
        while (i < n && j < n) {
            int sum = nums[i];
            for (int k = i + 1; k < j; k++) {
                sum = sum + nums[k];
            }
            if (sum > max1) {
                max1 = sum;
                startIndex = i;
                endIndex = j;
            }
            i++;
            j = i + firstLen;
        }
        for (int index = startIndex; index < endIndex; index++) {
            nums[index] = -1;
        }
        i = 0;
        int max2 = Integer.MIN_VALUE;
        while (i < nums.length) {
            int num = nums[i];
            if (num >= 0) {
                j = i + secondLen;
                for (int k = i + 1; j <= n && k < j; k++) {
                    num = num + nums[k];
                }
                max2 = Math.max(max2, num);
            }
            i++;
        }
        return max1 + max2;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{4, 0, 1};
        int[] nums1 = new int[]{0,6,5,2,2,5,1,9,4};
        int[] nums2 = new int[]{3,8,1,3,2,1,8,9,0};
        int[] nums3 = new int[]{2,1,5,6,0,9,5,0,3,8};
        int[] nums4 = new int[]{4,5,14,16,16,20,7,13,8,15};
        int firstLen = 3;
        int secondLen = 5;
        System.out.println(maxSumTwoNoOverlap(nums4, firstLen, secondLen));
    }
}
