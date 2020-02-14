package implementation;

import java.util.Arrays;

public class AlmostSorted {

    //TODO:SHUBHAM
    private static void almostSorted(int[] arr) {
        if (isAlreadySorted(arr)) {
            System.out.println("yes");
            return;
        }

        int[] sortedArray = new int[arr.length];
        for (int i=0; i <arr.length; i++) {
            sortedArray[i] = arr[i];
        }
        Arrays.sort(sortedArray);
        int ct = 0;
        int l = 0;
        int r = 0;
        for (int i=0; i <sortedArray.length; i++) {
            if (sortedArray[i] != arr[i]) {
                ct++;
            }
            if (ct > 2) {
                l = sortedArray[i];
                r = arr[i];
                break;
            }
        }
        if (ct == 2) {
            System.out.println("swap" + l + r);
            return;
        }

    }

    private static int getNumberOfSwaps(int[] arr) {
        return 0;
    }


    private static boolean isAlreadySorted(int[] arr) {
        for (int i=arr.length-1; i > 0; i--) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
