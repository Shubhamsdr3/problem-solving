package interviewprep_23.array;

public class SingleNumber {

    /**
     * Using XOR operator.
     * with TC -> O(n)
     * S.C -> O(1)
     */
    private static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num: nums) {
            ans = num ^ ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums));
    }
}
