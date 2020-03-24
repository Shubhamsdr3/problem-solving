package medium;

public class BinarySubArraysWithSum {

    /**
     * With time complexity : O(n * n-i)
     * Space : O(1)
     * @param A
     * @param S
     * @return
     */
    private static int numSubarraysWithSum(int[] A, int S) {
        int i = 0;
        int j;
        int count = 0;
        while (i < A.length) {
            if (A[i] == S) {
                count++;
            }
            int sum = A[i];
            for (j = i+1; j < A.length; j++) {
                sum = sum + A[j];
                if (sum == S) {
                    count++;
                }
            }
            i++;
        }
        return count;
    }

    /**
     * With time complexity: O(n)
     * space complexity: O(1)
     * @param A
     * @param S
     * @return
     */
    private static int numSubarraysWithSum1(int[] A, int S) {
        return atMost(A, S) - atMost(A, S - 1);
    }

    private static int atMost(int[] A, int S) {
        if (S < 0) {
            return 0;
        }
        int res = 0;
        int i = 0;
        int n = A.length;
        for (int j = 0; j < n; j++) {
            S = S - A[j];
            while (S < 0) {
                S = S + A[i++];
            }
            res = res + j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0};
        int[] arr1 = new int[]{1,0,1,0,1};
        int s = 0;
        int s1 = 2;
        System.out.println(numSubarraysWithSum1(arr1, s1));
    }
}
