package leetcode150.array;

public class RemoveElement {

    private static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                index++;
            } else {
                int j = index;
                while (j < nums.length && i + 1 < nums.length) {
                    nums[j] = nums[i + 1];
                    j++;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 3 };
        int val = 3;

        int[] arr1 = new int[] {0,1,2,2,3,0,4,2};
        int val1 = 2;
        System.out.println(removeElement(arr1, val1));
    }
}
