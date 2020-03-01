package easy;

import java.util.*;

public class ContainsDuplicate {

    private static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * using HashSet
     * TC: O(n)
     * @param nums
     * @return
     */
    private static boolean containsDuplicate1(int[] nums) {
        Set<Integer> set =  new HashSet<>();
        for (int num: nums) {
            if (!set.add(num)) {
                // if set.add(num) -> false means can't add to set its' duplicate element
                return true;
            }
        }
        return false;
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i =0; i < nums.length; i++) {
            int round = k;
            while (round > 0) {
                if (i+round < nums.length && nums[i] == nums[i+round]) {
                    return true;
                }
                round--;
            }
        }
        return false;
    }

    //Using set ds
    private static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) {
                // remove the oldest elements
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) {
                // false means can't add to set its' duplicate element
                return true;
            }
        }
        return false;
    }

    //MEDIUM: TLE
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 1) {
            return false;
        }
        int i = 0;
        while (i < nums.length) {
            int j = i+1;
            while (j <= i+k && j < nums.length) {
                int diff = 0;
                while (diff <= t) {
                    if (Math.abs(nums[i] - nums[j]) == diff) {
                        return true;
                    }
                    diff++;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    // Time O(nlog(min(n, k))
    private static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
       TreeSet<Long> set =  new TreeSet<>();
       for (int i =0; i < nums.length; i++) {
           Long floor = set.floor((long) nums[i]);
           if (floor != null && nums[i] - floor <= t) {
               return true;
           }

           Long ceieling = set.ceiling((long) nums[i]);
           if (ceieling != null && ceieling - nums[i] <= t) {
               return true;
           }

           set.add((long) nums[i]);
           if (set.size() > k) {
               set.remove((long) nums[i - k]);
           }
       }

       return false;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int[] arr1 = new int[]{1,0,1,1};
        int[] arr2 = new int[]{1,5,9,1,5,9};
        int[] arr3 = new int[]{2, 1};
//        System.out.println(containsNearbyAlmostDuplicate(arr1, 1, 2));
//        System.out.println(containsNearbyAlmostDuplicate(arr, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate1(arr2, 2, 3));
        System.out.println(containsNearbyAlmostDuplicate(arr3, 1, 1));

//        System.out.println(containsDuplicate1(arr));
    }
}
