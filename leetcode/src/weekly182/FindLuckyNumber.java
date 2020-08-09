package weekly182;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyNumber {

    private static int findLucky(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i =0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) +1);
        }

        int largest = -1;
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue().equals(entry.getKey()) && entry.getKey() > largest) {
                largest = entry.getKey();
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,7,7,7,7,7,7};
        System.out.println(findLucky(arr));
    }
}
