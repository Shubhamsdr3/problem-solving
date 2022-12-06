package easy;

public class PartitionArrayIntoThreeParts {

    /**
     * Naive approach
     * @param arr
     * @return
     */
    private static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int e: arr) {
            sum = sum + e;
        }
        if (sum % 3 != 0) return false;
        int n = arr.length;
        int currentSum = 0;
        int found = 0;
        sum = sum / 3;
        for (int e: arr) {
            if ((currentSum = currentSum + e) == sum) {
                if (++found == 3) return true;
                currentSum = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(canThreePartsEqualSum(arr));
    }
}
