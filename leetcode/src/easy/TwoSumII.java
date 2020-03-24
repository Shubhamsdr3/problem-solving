package easy;

import java.util.Arrays;

public class TwoSumII {

    //O(n2) solution
    private static int[] twoSum(int[] numbers, int target) {
        for (int i= 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{0};
    }

    //Using tow pointer
    private static int[] twoSum1(int[] numbers, int target) {
        int[] indices = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while (left  < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                indices[0] = left +1;
                indices[0] = right +1;
                return indices;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
