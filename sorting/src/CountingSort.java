import java.util.Arrays;

public class CountingSort {

    /**
     * Does not use comparison.
     * Use assumption of range of data.(eg: in this case 1 t0 10 inclusive)
     * @param arr: To sort.
     * @param min: The minimum range value(1)
     * @param max : The maximum range value(10)
     * @return : sorted array.
     */
    private static int[] countingSort(int[] arr, int min, int max) {
        // Array to store the occurrences of each element.
        int[] countArray =  new int[max];
        for (int value : arr) {
            countArray[value - min]++;
        }
        //Now put the values back to input array.
        int j= 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                arr[j++] = i;
                countArray[i - min]--;
            }
        }
        return arr;
    }

//    private static int[] stableCountingSort(int[] arr, int min, int max) {
//        int[] temp = new int[arr.length];
//        for (int k = arr.length -1; k >= 0; k --) {
//            temp[k] =
//        }
//
//
//    }

    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 5, 9, 8, 2, 7, 10, 4, 3, 6, 9, 5};
        System.out.println(Arrays.toString(countingSort(inputArray, 1, 10)));
    }
}
