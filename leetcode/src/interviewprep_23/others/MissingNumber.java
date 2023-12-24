package interviewprep_23.others;

import java.util.HashMap;
import java.util.Map;

public class MissingNumber {


    private static int missingNumberWithoutSpace(int[] nums) {
        return 0;
    }

    /**
     * With extra space of O(n)
     * T.C -> O(n)
     * @param nums
     * @return
     */
    private static int missingNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i , nums[i]);
        }

        for (int i = 0; i <= n; i++) {
            if (!map.containsValue(i)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 0, 1 };
        int[] nums1 = new int[] { 9,6,4,2,3,5,7,0,1 };
        System.out.println(missingNumber(nums1));
    }
}
