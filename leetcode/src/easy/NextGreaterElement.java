package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int index = 0;
       for (int i = 0; i < nums1.length; i++) {
           int num = nums1[i];
           for (int j = 0; j < nums2.length; j++) {
               if (nums2[j] == num) {
                   int nextGreaterIndex = j+1;
                   while (nextGreaterIndex < nums2.length) {
                       if (nums2[nextGreaterIndex] > num) {
                           result[index] = nums2[nextGreaterIndex];
                           index++;
                           break;
                       }
                       nextGreaterIndex++;
                   }
                   if (nextGreaterIndex == nums2.length) {
                       result[index] = -1;
                       index++;
                   }
               }
           }
       }
       return result;
    }

    /**
     * Efficient once: O(n)
     * using monotonus stack
     */

    private static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> increasingStack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int num : nums2) {
            while (!increasingStack.isEmpty() && increasingStack.peek() < num) {
                map.put(increasingStack.pop(), num);
            }
            increasingStack.push(num);
        }
        for (int i=0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 1, 2};
        int[] arr2 = new int[] {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement1(arr1, arr2)));
    }
}
