package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumIndexSum {

    private static String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (int i =0; i < list1.length; i++) {
            for (int j =0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int sum = i +j;
                    if (sum <= min) {
                        min = sum;
                        result.add(list1[i]);
                    }
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] arr1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] arr2 = new String[]{"KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(Arrays.toString(findRestaurant(arr1, arr2)));
    }
}
