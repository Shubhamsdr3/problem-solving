package medium;

public class WiggleSequence {

    private static int wiggleMaxLength(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length -1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (i % 2 == 0 && diff > 0) {
                count++;
            } else if (diff < 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 7, 4, 9, 2, 5 };
        int[] arr1 = new int[] {1,17,5,10,13,15,10,5,16,8};
        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(wiggleMaxLength(arr2));
    }
}
