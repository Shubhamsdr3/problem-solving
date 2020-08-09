package weekly197;

public class NumberOfGoodPairs {

    private static int numIdenticalPairs(int[] nums) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(numIdenticalPairs(arr));
    }
}
