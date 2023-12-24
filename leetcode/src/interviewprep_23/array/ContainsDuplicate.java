package interviewprep_23.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 3, 4 };
        System.out.println(containsDuplicate(arr));
    }
}
