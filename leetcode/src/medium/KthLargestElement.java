package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    /**
     * T.C: O(nlogn) in sorting
     * @param nums
     * @param k
     * @return
     */
    private static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * using Priority Queue
     * @param nums
     * @param k
     * @return
     */
    private static int findKthLargestUsingPQ(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    private static int findKthLargestUsingPartition(int[] nums, int k) {
        k = nums.length -k;
        int low = 0;
        int high = nums.length -1;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = j -1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (i < high && nums[++i] < nums[low]);
            while (j > low && nums[low] < nums[--j]);
            if (i >= j) {
                break;
            }
        }
        exchange(nums, low, j);
        return j;
    }

    private static void exchange(int[] nums, int low, int j) {
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargestUsingPartition(arr, 4));
    }
}
