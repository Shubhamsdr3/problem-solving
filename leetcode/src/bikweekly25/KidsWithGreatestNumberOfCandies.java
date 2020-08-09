package bikweekly25;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int largest = Integer.MIN_VALUE;
        for (int item: candies) {
            if (item > largest) {
                largest = item;
            }
        }
        List<Boolean> result = new ArrayList<>();

        for (int item: candies) {
            if (item + extraCandies < largest) {
                result.add(false);
            } else  {
                result.add(true);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,1,12};
        int extraCandies = 10;
        System.out.println(kidsWithCandies(arr, extraCandies));
    }
}
