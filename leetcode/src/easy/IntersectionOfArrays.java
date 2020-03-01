package easy;

import java.util.*;

public class IntersectionOfArrays {

    private static int[] intersect(int[] nums1, int[] nums2) {
        int i = 0;
        int[] minArray =  nums1;
        int[] maxArray = nums2;
        if (minArray.length > maxArray.length) {
            minArray = nums2;
            maxArray = nums1;
        }

        Set<Integer> list = new HashSet<>();
        while (i < minArray.length) {
            for (int j =0; j < maxArray.length; j++) {
                if (minArray[i] == maxArray[j]) {
                    list.add(minArray[i]);
                    maxArray[j] = Integer.MIN_VALUE;
                    break;
                }
            }
            i++;
        }

        int[] result = new int[list.size()];
        int index =0;
        for (Integer integer : list) {
            result[index] = integer;
            index++;
        }
        return result;
    }

    private static int[] intersect1(int[] nums1, int[] nums2) {
        int i = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] minArray =  nums1;
        int[] maxArray = nums2;
        if (minArray.length > maxArray.length) {
            minArray = nums2;
            maxArray = nums1;
        }

        List<Integer> list = new ArrayList<>();

        while (i < minArray.length) {
            if (minArray[i] == maxArray[i]) {
                list.add(minArray[i]);
            }
            i++;
        }

        int[] result = new int[list.size()];
        for (int k =0; k < list.size(); k++) {
            result[k]= list.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,2,1};
        int[] arr2 = new int[]{2,2};

        int[] arr3 = new int[]{4,9,5};
        int[] arr4 = new int[]{9,4,9,8,4};

        int[] arr5 = new int[]{1, 2};
        int[] arr6 = new int[]{1, 1};

        int[] arr7 = new int[]{3, 1, 2};
        int[] arr8 = new int[]{1, 1};

        System.out.println(Arrays.toString(intersect(arr1, arr2)));
        System.out.println(Arrays.toString(intersect(arr3, arr4)));
        System.out.println(Arrays.toString(intersect(arr5, arr6)));
        System.out.println(Arrays.toString(intersect(arr7, arr8)));
    }
}
