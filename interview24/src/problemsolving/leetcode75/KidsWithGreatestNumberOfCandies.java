package problemsolving.leetcode75;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KidsWithGreatestNumberOfCandies {

    /**
     * T.C -> O(n)
     * @param candies
     * @param extraCandies
     * @return
     */
    private static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int candy: candies) {
            max = Math.max(candy, max);
        }
        for (int candy: candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }

    /**
     * T.C -> O(n^2)
     * @param candies
     * @param extraCandies
     * @return
     */
    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            int num = candies[i] + extraCandies;
            boolean isLargest = true;
            for (int j = 0; j < candies.length; j++) {
                if (i != j && num < candies[j]) {
                    isLargest = false;
                }
            }
            result.add(isLargest);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] kids = new int[] { 2, 3, 5, 1, 3 };
        int extraCandies = 3;

        int[] kids1 = new int[] {4, 2, 1, 1, 2};
        int extraCandies1 = 1;

        int[] kids2 = new int[] {2, 8, 7};
        int extraCandies2 = 1; // [false, true, true]
        System.out.println(kidsWithCandies2(kids2, extraCandies2));
    }
}
