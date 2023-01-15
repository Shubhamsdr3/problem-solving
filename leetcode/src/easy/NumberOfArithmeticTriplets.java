package easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfArithmeticTriplets {

    /**
     * Accepted
     * TC -> O(n^3)
     * @param nums
     * @param diff
     * @return
     */
    private static int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[j] - nums[i]) == diff && nums[k] - nums[j] == diff) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int arithmeticTripletsV2(int[] nums, int diff) {
        int count = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        for (int num : nums) {
            boolean isPresent = ((map.get(num - diff) != null && map.get(num - diff)) && (map.get(num + diff)) != null && (map.get(num + diff)));
            if (isPresent) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 6, 7, 10};
        int diff = 3;

        int[] arr1 = new int[]{4, 5, 6, 7, 8, 9};
        int diff1 = 2;
        System.out.println(arithmeticTripletsV2(arr1, diff1));
    }
}
