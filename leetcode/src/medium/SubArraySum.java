package medium;

public class SubArraySum {

    private static int subarraySum(int[] nums, int k) {
        if (nums.length ==1 && nums[0] == k) {
            return 1;
        }
        int count = 0;
        int i =0;
        while (i < nums.length ) {
            if (nums[i] == k) {
                count++;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k) {
                    count++;
                    i++;
                }
            }
            i++;

        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,1,2,3,4};
        int[] arr1 = new int[]{1,2,3};
        int k = 3;
        int k1 = 6;
        System.out.println(subarraySum(arr, k1));
    }
}
