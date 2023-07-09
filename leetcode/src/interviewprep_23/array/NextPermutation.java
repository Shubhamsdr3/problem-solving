package interviewprep_23.array;

import java.util.Arrays;

public class NextPermutation {

    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = 0;
        int l = 0;
        for (k = n - 2; k >= 0; k--) {
            if (nums[k] < nums[k + 1]) {
                break;
            }
        }
        if (k < 0) {
            reverse(0, n - 1);
        } else {
            for (l = n - 1; l > k; l--) {
                if (nums[l] > nums[k]) {
                    break;
                }
            }
            swap(nums[k], nums[l]);
            reverse(k + 1, n);
        }
    }

    private static void swap(int num, int num1) {

    }

    private static void reverse(int start, int end) {

    }


    /**
     * Heaps algorithm
     * @param nums
     * @return
     */
    private static void heapPermutation(int[] nums, int size) {
        for (int i = 0; i < size; i++) {
            heapPermutation(nums, size - 1);
            // if size is odd , swap 0th(first) and (size - 1) last element.
            int temp;
            if (size % 2 == 1) {
                temp = nums[0];
                nums[0] = nums[size - 1];
            } else {
                temp = nums[i];
                nums[i] = nums[size - 1];
            }
            nums[size - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] inputs = new int[] { 1, 2, 3 };
        nextPermutation(inputs);
    }
}
