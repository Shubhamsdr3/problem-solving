package greedyalgorithm;

public class MyUtils {

    static int sumArray(Integer[] arr) {
        int sum =0 ;
        for (int val: arr) {
            sum = sum + val;
        }
        return sum;
    }

    public static int sumArray(int[] arr) {
        int sum =0 ;
        for (int val: arr) {
            sum = sum + val;
        }
        return sum;
    }

    static int arrayToInt(int[] arr) {
        StringBuilder strNum = new StringBuilder();
        for (int num : arr) {
            strNum.append(num);
        }
        return Integer.parseInt(strNum.toString());
    }

    public static void swapElement(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findMaxInArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i< arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    public static int findMaxIndex(int[] arr) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i=0; i< arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}
