package searchalgorithm;

import java.util.Arrays;

public class Pairs {

    /**
     * @param k
     * @param arr
     * @return
     */
    private static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int count = 0;
       for (int i=0; i < arr.length -1; i++) {
           for (int j=i+ 1; j <= arr.length -1; j++) {
               if (arr[j] - arr[i] == k) {
                   count++;
               }
           }
       }
       return count;
    }

    /**
     * Two pointer approach
     * @param k
     * @param arr
     * @return
     */
    private static int pairs1(int k, int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int i=0;
        int j =1;
        while (j < arr.length) {
            int diff = arr[j] - arr[i];
            if (diff == k) {
                count++;
                j++;
            } else if (diff > k) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int targetVal = 2;
        int[] input = new int[]{1, 5, 3, 4, 2};
        System.out.println(pairs(targetVal, input));
    }
}
