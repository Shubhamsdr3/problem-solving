package easy;

public class MissingNumber2 {

    /**
     * Given a number from  1..n
     * T.C : O(n)
     *
     * @param arr
     * @return
     */
    private static int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = ((n + 1) * (n + 2)) / 2; // sum of all natural numbers n(n +1) / 2 : n -> n + 1 (including missing element)
        for (int i = 0; i < n; i++) {
            sum = sum - arr[i];
        }
        return sum;
    }

    /**
     * Using XOR
     * T.C : O(n)
     * @param arr
     * @return
     */
    private static int missingNumber1(int[] arr) {
        int n = arr.length;
        int x1 = arr[0];
        int x2 = 1;
        for (int i = 1; i < n; i++) { // XOR for array elements.
            x1 = x1 ^ arr[i];
        }
        for (int i = 2; i <= n + 1; i++) {  // XOR for elements 1..n
            x2 = x2 ^ i;
        }
        return (x1 ^ x2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 6};
        System.out.println(missingNumber1(arr));
    }
}
