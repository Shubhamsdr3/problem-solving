package medium;

import java.util.*;

public class BeautifulArrangementII {

    private static int findShortestSubArray(int[] nums) {
        int degreeOfTheArray = findDegree(nums, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = degreeOfTheArray; j < nums.length; j++) {
                if (degreeOfTheArray == findDegree(nums, i, j)) {
                    return j - i;
                }
            }
        }
        return 0;
    }

    private static int findDegree(int[] arr, int start, int end) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        for (int i = start; i < end; i++) {
            degreeMap.put(arr[i], degreeMap.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>(degreeMap.values());
        Collections.sort(list);
        return list.get(list.size() -1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,1,4,2, 3, 5, 3, 6, 3};
        System.out.println(findShortestSubArray(arr));
    }
}
