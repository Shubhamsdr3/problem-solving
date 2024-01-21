package leetcode75.array;

import java.util.Arrays;

public class MergeSortedArray {


    /**
     * Rather than filling from start to end, do it in reverse.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n -1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    /**
     * My approach :(
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int temp = -1;
        while (i < nums1.length && j < n) {
            if (temp >= 0 && temp <= nums2[j]) {
                nums1[i] = temp;
                temp = -1;
            } else if (nums1[i] <= nums2[j]) {
                break;
            } else if (nums1[i] == 0) {
                nums1[i] = nums2[j];
            } else {
                temp = nums1[i];
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{ 1, 2, 3, 0, 0, 0 };
        int[] arr2 = new int[]{ 2, 5, 6};
        int m = 3;
        int n = 3;
        merge1(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
    }
}
