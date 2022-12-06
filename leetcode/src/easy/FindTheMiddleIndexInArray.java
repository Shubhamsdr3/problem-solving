package easy;

public class FindTheMiddleIndexInArray {

    private static int findMiddleIndex(int[] nums) {
        int total = 0;
        for (int num: nums) {
            total = total + num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum * 2 == total + nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -1, 8, 4};
        int[] arr1 = new int[]{1, -1, 4};
        System.out.println(findMiddleIndex(arr1));
    }
}
