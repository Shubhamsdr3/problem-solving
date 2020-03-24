package easy;

import java.util.*;

public class SubsetsII {

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new LinkedHashSet<>();
        set.add(new ArrayList<>());

        for (int i =0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                set.add(getList(nums, i, j));
            }
        }
        set.add(getList(nums, 0, nums.length));
        return new ArrayList<>(set);
    }

    private static List<Integer> getList(int[] arr, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i=start; i < end; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }
}
