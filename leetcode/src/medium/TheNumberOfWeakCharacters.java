package medium;

import java.util.Arrays;

public class TheNumberOfWeakCharacters {

    /**
     * compare() :
     * -1 -> for less than
     * 0 -> for equal
     * 1 -> greater
     * @param properties
     * @return
     */

    private static int numberOfWeakCharacters1(int[][] properties) {
        int count = 0;
        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return (o1[1] > o2[1]) ? -1 : 1;
            }
            return (o1[0] < o2[0]) ? -1: 1;
        });

        int max = Integer.MIN_VALUE;
        for (int i = properties.length -1; i >= 0; i--) {
            if (properties[i][1] < max) {
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return count;
    }


    private static int numberOfWeakCharacters(int[][] properties) {
        int count = 0;
        for (int i = 0; i < properties.length; i++) {
            int[] arr = properties[i];
            boolean isWeak = false;
            for (int j = 0; j < properties.length; j++) {
                if (i != j) {
                    int[] arr2 = properties[j];
                    isWeak = arr[0] < arr2[0] && arr[1] < arr2[1];
                }
                if (isWeak) count++;
                isWeak = false;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int[][] arr = new int[][] {{5, 5}, {6, 3}, {3, 6}};
        int[][] arr1 = new int[][] {{2, 2}, {3, 3}};
        int[][] arr2 = new int[][] {{1, 5}, {10, 4}, {4, 3}};
        int[][] arr3 = new int[][] {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
        int[][] arr4 = new int[][] {{1, 5}, {10, 4}, {4, 3}};
        int[][] arr5 = new int[][] {{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}};
//        System.out.println(numberOfWeakCharacters(arr));
//        System.out.println(numberOfWeakCharacters(arr1));
//        System.out.println(numberOfWeakCharacters(arr2));
        System.out.println(numberOfWeakCharacters1(arr5));
    }
}
