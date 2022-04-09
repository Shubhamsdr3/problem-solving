package easy;

public class CountEqualAndDivisiblePairsInArray {

    private static int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {
                1, 2, 3, 4
        };
        int k = 2;
        System.out.println(countPairs(arr, k));
    }
}
