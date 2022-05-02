package medium;

import java.util.*;

public class ThreeSum {

    /**
     * Time Limit Exceed.
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int num3 = nums[k];
                    if (num1 + num2 + num3 == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(num1);
                        list.add(num2);
                        list.add(num3);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static List<List<Integer>> threeSumImproved(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> res = new LinkedList<>();
       for (int i = 0; i < nums.length -2; i++) {
           if (i == 0 || (i > 0 && nums[i] != nums[i -1])) {
               int low = i + 1;
               int hi = nums.length -1;
               int sum = -nums[i];
               while (low < hi) {
                   if (nums[low] + nums[hi] == sum) {
                       res.add(Arrays.asList(nums[i], nums[low], nums[hi]));
                       while (low < hi && nums[low] == nums[low + 1]) low++;
                       while (low < hi && nums[hi] == nums[hi -1]) hi--;
                       low++;
                       hi--;
                   } else if (nums[low] + nums[hi] < sum) low++;
                   else  hi--;
               }
           }
       }
       return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSumImproved(arr));
    }
}
