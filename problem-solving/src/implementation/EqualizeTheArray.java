package implementation;

import java.util.Arrays;

public class EqualizeTheArray {

    private static int equalizeArray(int[] arr) {
        int[] count = new int[101]; // make sure the size + 1
        for (int value : arr) {
            count[value]++;
        }
        Arrays.sort(count);
        int sum = 0;
        for (int i = count.length -2; i > 0; i--) {
            sum = sum + count[i];
        }
        return sum;
    }

    public static void main(String[] args){
        int[] arr = new int[]{10, 27, 9, 10, 100, 38, 30, 32, 45, 29, 27, 29, 32, 38, 32, 38, 14, 38, 29, 30, 63, 29, 63, 91, 54, 10, 63};
        System.out.println(equalizeArray(arr));
    }
}
