package greedyalgorithm;

import java.util.Arrays;

public class BeautifulPairs {

    /**
     * Bucket algorithm
     * @param A
     * @param B
     * @return
     */
    private static int beautifulPairs(int[] A, int[] B) {
        int count = 0;
        int[] bucket = new int[1001];
        for (int i = 0; i < A.length; i++) {
            bucket[A[i]]++;
        }

        for (int j=0; j < B.length; j++) {
            if (bucket[B[j]] > 0) {
                count++;
                bucket[B[j]]--;
            }
        }

        if (count == A.length) {
            count--;
        } else {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{1, 2, 3, 3};

        int[] a1 = new int[]{3, 5, 7, 11, 5, 8};
        int[] b1 = new int[]{5, 7, 11, 10, 5, 8};

        System.out.println(beautifulPairs(a1, b1));
    }
}
