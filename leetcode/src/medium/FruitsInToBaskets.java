package medium;

import java.util.*;

public class FruitsInToBaskets {

    private static int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int j = 0;
        int i = 0;
        for (; j < fruits.length; j++) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1); // count the fruits.
            if (count.size() > 2) { // more than two baskets.
                count.put(fruits[i], count.get(fruits[i] - 1));
                count.remove(fruits[i++], 0);
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 3, 2, 2 };
        int[] arr1 = new int[]{ 0, 1, 2, 2 };
        int[] arr2 = new int[]{ 1, 2, 1 };
        int[] arr3 = new int[]{ 3,3,3,1,2,1,1,2,3,3,4 };
        System.out.println(totalFruit(arr3));
    }
}
