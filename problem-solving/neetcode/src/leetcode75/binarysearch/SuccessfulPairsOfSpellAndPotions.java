package leetcode75.binarysearch;

import java.util.Arrays;

public class SuccessfulPairsOfSpellAndPotions {

    private static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions); // sorting O(nlogn)
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int start = 0;
            int end = m - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                int midElement = potions[mid];
                long product = (long) spell * midElement;
                 if (product >= success) {
                    end = mid - 1;
                } else  {
                    start = mid + 1;
                }
            }
            pairs[i] = m - start;
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] spells = new int[] { 5, 1, 3 };
        int[] potions = new int[] { 1, 2, 3, 4, 5 };
        int success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }
}
