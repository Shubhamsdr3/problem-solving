package searchalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockAndArray {

    private static String balancedSums(List<Integer> arr) {
        if (arr.size() == 1) {
            return "YES";
        }

        int pivot = 0;
        if (arr.get(pivot + 1) == 0) {
            return "YES";
        }

        pivot = 1;

        if (arr.get(pivot -1).equals(arr.get(pivot + 1))) {
            return "YES";
        }

        while (pivot <= arr.size()) {
            int leftSum = 0;

            // Move left to the pivot
            for (int i = pivot - 1; i >= 0; i--) {
                leftSum = leftSum + arr.get(i);
                int rightSum = 0;
                // Move right to the pivot
                for (int j = pivot + 1; j  < arr.size(); j++) {
                    rightSum = rightSum + arr.get(j);
                    if (leftSum == rightSum) {
                        return "YES";
                    }
                }
            }
            pivot ++;
        }
        return "NO";
    }


    /**
     *
     * //THE Correct one.
     * pivot = y
     * x--- y --- x
     * x + x + y = sumOfArrayElements
     * 2x + y = sumOfArrayElements
     * 2x = sumOfArray - y
     *
     * @param arr
     * @return
     */

    private static String balancedSums1(List<Integer> arr) {
        int x = 0;
        int sumOfArray =0;

        for (int a: arr) {
            sumOfArray += a;
        }

        for (int y: arr) {
            if (2 * x == sumOfArray - y) {
                return "YES";
            }
            x = x + y;
        }
        return "NO";
    }
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 1, 4, 1, 1));
        List<Integer> integerList1 = new ArrayList<>(Arrays.asList(2, 0, 0, 0));
        List<Integer> integerList2 = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<Integer> integerList3 = new ArrayList<>(Arrays.asList(1, 2, 3, 3));

        List<Integer> integerList4 = new ArrayList<>(Arrays.asList(0, 0, 2, 0));

        System.out.println(balancedSums1(integerList));
        System.out.println(balancedSums1(integerList1));
        System.out.println(balancedSums1(integerList2));
        System.out.println(balancedSums1(integerList3));
        System.out.println(balancedSums1(integerList4));
    }
}
