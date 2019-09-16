package sortingproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumber {

    private static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] -  arr[i -1];
            if (diff <= min) {
                // Found another minimum.
                // Clear the list and store another minimum.
                if (diff < min) {
                    list.clear();
                }
                min = diff;
                list.add(arr[i - 1]);
                list.add(arr[i]);
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-5, 15, 25, 71, 63};
        closestNumbers(arr);
        System.out.println(Arrays.toString(closestNumbers(arr)));
    }
}
