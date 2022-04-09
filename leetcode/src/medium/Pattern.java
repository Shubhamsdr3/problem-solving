package medium;

public class Pattern {

    private static boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (num1 < nums[k] && nums[k] < num2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int[] arr1 = new int[]{3, 1, 4, 2};
        int[] arr2 = new int[]{-1, 3, 2, 0};
        System.out.println(find132pattern(arr2));
    }
}
