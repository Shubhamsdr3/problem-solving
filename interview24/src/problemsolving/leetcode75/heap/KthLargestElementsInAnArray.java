package problemsolving.leetcode75.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementsInAnArray {

    /**
     * Best case : O(n)
     * worst case: O(n^2)
     * @param nums
     * @param k
     * @return
     */
    private static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * My apprach: wrong.
     * @param nums
     * @param k
     * @return
     */
    private static int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        List<Integer> maxElements = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i++) {
            if(nums[i] >= max || k <= maxElements.size()) {
                maxElements.add(0, nums[i]);
                max = nums[i];
            }
        }
        System.out.println(maxElements);
        return maxElements.get(k - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,2,3,1,2,4,5,5,6 };
        int k = 4;

        int[] arr1 = new int[] {3, 2, 1, 5, 6, 4};
        int k1 = 2;

        int[] arr2 = new int[] {2, 1};
        int k2 = 2;
        System.out.println(findKthLargest1(arr2, k2));
    }
}
