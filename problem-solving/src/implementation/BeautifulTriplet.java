package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeautifulTriplet {

    //TODO: Optimize it to O(n)
    private static int beautifulTriplets(int d, int[] arr) {
        int[] triplets = new int[3];
        int count = 0;
        for (int i=0; i < arr.length; i++) {
            int k =0;
            triplets[k] = arr[i];
            for (int j= i+1; j < arr.length ; j++) {
                if (arr[j] - triplets[k] == d) {
                    k++;
                    triplets[k] = arr[j];
                }
                if (k == 2) {
                    if (isBeautifulTriplet(triplets, d)) {
                        count++;
                    }
                    break;
                }
            }
        }
        return count;
    }

    private static int beautifulTriplets1(int d, int[] arr) {
        int[] triplets = new int[3];

        int count = 0;
        for (int i=0; i < arr.length; i++) {
            int k =0;
            triplets[k] = arr[i];
            int element = triplets[k] + d;
            if (isExist(arr, element, i)) {
                k++;
                triplets[k] = element;
            }
            if (k == 2 && isBeautifulTriplet(triplets, d)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isExist(int[] arr, int element, int index) {
        for (int i = index; i < arr.length; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;
    }


    private static boolean isBeautifulTriplet(int[] arr, int d) {
        for (int i=arr.length-1; i > 0; i--) {
            if (arr[i] - arr[i-1] != d) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 4, 5, 7, 8, 10};
        int d = 3;
        System.out.println(beautifulTriplets1(d, inputArray));
    }
}
