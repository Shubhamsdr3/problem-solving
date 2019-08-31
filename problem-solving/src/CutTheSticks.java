import java.util.Arrays;

public class CutTheSticks {

    private static int[] cutTheSticks1(int[] arr) {
        int minimum = Utils.findMinimumOfArray(arr);
        int[] result = new int[arr.length];
        result[0] = arr.length;
        int count = 0;
        for (int i=0; i < arr.length; i++) {
           int minus = arr[i] - minimum;
           if (minus != 0) {
               arr[i] = minus;
               count++;
           }
           result[i] =count;
        }
        return result;
    }

    private static int[] cutTheSticks2(int[] arr) {
        int[] result =  new int[4];
        Arrays.sort(arr);
        result[0] = arr.length;
        for (int i=1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                result[i] = arr.length - i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 4, 4, 2, 2, 8};
        System.out.println(Arrays.toString(cutTheSticks2(arr)));
    }
}
