package easy;

import java.util.Arrays;

public class RelativeSortArray {

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length];
        int index = 0;
        for (int i =0; i < arr2.length; i++) {
            int element = arr2[i];
            for (int j = 0; j < arr1.length; j++) {
                if (element == arr1[j]) {
                    arr[index] = element;
                    arr1[j] = -1;
                    index++;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != -1) {
                arr[index] = arr1[i];
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}
