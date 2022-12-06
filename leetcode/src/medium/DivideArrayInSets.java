package medium;

import java.util.PriorityQueue;

public class DivideArrayInSets {

    private static boolean isPossibleDivide(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        while (!pq.isEmpty()) {
            int smallest = pq.peek();
            for (int i = 0; i < k; i++) {
                if (!pq.contains(smallest + i)) return false;
                else pq.remove(smallest + i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,2,3,4,3,4,5,9,10,11};
        int k = 3;
        System.out.println(isPossibleDivide(nums, k));
    }
}
