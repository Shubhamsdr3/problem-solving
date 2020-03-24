package medium;

import java.util.*;

public class MajorityElement {

    private static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > Math.floor(nums.length / 3)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    /**
     * Moore's voting algorithm
     * Finding majority element with frequency greater than n/2
     * @param nums
     * @return
     */
    private static int majorityElement1(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // find the right candidate
        for (int i =1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count ==  0) {
                candidate = nums[i];
                count = 1;
            }
        }
        // check if it's the right candidate
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count1++;
            }
        }
        if (count1 > Math.floor(nums.length / 2)) {
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,3,3,2,2,2};
        int[] arr1 = new int[]{3, 2, 3};
        System.out.println(majorityElement1(arr1));
    }
}
