package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays2 {

    private static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i =0; i < nums1.length; i++) {
            for (int j =0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    nums1[i] = -1;
                    nums2[j] = -1;
                    break;
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,2,1};
        int[] arr2 = new int[]{2};
        System.out.println(Arrays.toString(intersect(arr1, arr2)));
    }
}
