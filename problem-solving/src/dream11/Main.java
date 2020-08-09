package dream11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * Method 1  : Totally in-effiecient
     * @param arr
     * @return
     */
    // space complexity: O(n)
    // time complexity : O(n)
    private static int[] reverseArray(int[] arr) {
        int a[]=new int [arr.length]; // temp array
        int n = arr.length -1;
        int start = 0;
        for (int i = n; i >=0; i--) {
            a[start] = arr[i];
            start++;
        }
        return a;
    }

    /**(
     * Method 2
     * @param arr
     */
    private static void reverseArray1(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while (start < arr.length/2) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    /**
     * By definition, pass by value means you are making a copy in memory of the actual parameter's value that is passed in,
     * a copy of the contents of the actual parameter. ...
     * In pass by reference (also called pass by address), a copy of the address of the actual parameter is stored
     */

    public static void main(String[] args) {
        int[] inputArray = new int[] {3, 4 , 6 , 7, 5, 8};
        reverseArray1(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }
}