package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    private static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > Math.floor(nums.length / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3};
        System.out.println(majorityElement(arr) );
    }
}
