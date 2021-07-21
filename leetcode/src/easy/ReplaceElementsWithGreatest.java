package easy;

import java.util.Arrays;

public class ReplaceElementsWithGreatest {

    private static int[] replaceElements(int[] arr) {
        int start = 0;
        while (start < arr.length) {
            int maximum = findGreatest(start+1, arr);
            arr[start] = maximum;
            start++;
        }
        return arr;
    }

    private static int findGreatest(int start, int[] arr) {
        int largest = -1;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] input = new int[] {
                17, 18, 5, 4, 6, 1
        };
        System.out.println(Arrays.toString(replaceElements(input)));
    }
}
