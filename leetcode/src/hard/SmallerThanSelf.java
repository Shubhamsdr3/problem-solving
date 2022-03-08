package hard;

import java.util.ArrayList;
import java.util.List;

public class SmallerThanSelf {

    private static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        int start = 0;
        while (start < nums.length) {
            int count = 0;
            int num = nums[start];
            for (int i = start + 1; i < nums.length; i++) {
                if (nums[i] < num) {
                    count++;
                }
            }
            list.add(start, count);
            start++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 6, 1};
        int[] arr1 = new int[]{-1, -1};
        System.out.println(countSmaller(arr1));
    }
}
