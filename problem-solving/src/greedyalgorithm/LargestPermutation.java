package greedyalgorithm;

import java.util.Arrays;

//FIXME: SHUBHAM
public class LargestPermutation {

    // Complete the largestPermutation function below.
    private static int[] largestPermutation(int k, int[] arr) {
        while (k > 0) {
            for (int j=0; j < arr.length; j++) {
                int maxIndex = findMaxIndex(arr, j);
                swapElement(arr, j, maxIndex);
                k--;
                if (k == 0) {
                    break;
                }
            }
        }
        return arr;
    }

    private static int findMaxIndex(int[] arr, int startIndex) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = startIndex; i< arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static void swapElement(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]
                {
                        138, 163, 109, 46, 85, 21, 18, 124, 149, 139, 128, 156, 73 ,2 ,129, 142, 166, 78, 162, 102, 13,
                        36, 150, 161, 134, 69, 41, 111, 31, 116, 87, 12, 47, 72, 22, 35, 82, 89, 130, 43, 44, 71,
                        115, 66, 90, 178, 40, 7, 67, 95, 146, 88, 59, 34, 154, 81, 137, 99, 159, 174, 96, 14, 32,
                        8, 24, 77, 160, 170, 5, 70, 97, 172 ,83, 151, 33, 145 ,68 ,127 ,51 ,56 ,4 ,126, 55 ,177 ,29
                        ,123, 148, 108, 53, 57 ,17, 135, 63 ,114, 143, 94 ,19, 157, 171, 26, 110 ,11 ,173, 10, 106,
                        100 ,30 ,58, 74, 45 ,120, 144 ,39, 175, 48 ,20 ,37, 42 ,75, 25, 141, 50, 153, 80, 49, 132,
                        65, 140, 152, 54, 64 ,101, 92, 103, 155 ,61, 60, 121, 107 ,76 ,136, 79, 117 ,133 ,104, 86 ,16,
                        91, 179, 118, 122, 169, 168 ,84 ,113, 28, 3, 164, 105, 62, 38, 125, 147, 52, 119, 112, 1, 15,
                        23, 176, 27, 158, 93, 98, 165, 167, 6, 131, 9
                };

        int[] arr1 = new int[]{4, 2, 3, 5, 1};
        System.out.println(Arrays.toString(largestPermutation(220, arr)));
    }


}
