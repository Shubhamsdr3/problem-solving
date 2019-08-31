import java.util.Arrays;

public class RadixSort {

    /**
     * Use stable counting sorting algorithm to sort the elements.
     * @param inputArray : Array to be sorted.
     * @param radix : For decimat number = 10.
     * @param width:  Number of digits in an element.
     * @return : sorted array.
     */
    public static int[] radixSort(int[] inputArray, int radix, int width) {
        for (int i =0; i < width; i++) {
            radixSingleSort(inputArray, i, radix);
        }
        return inputArray;
    }

    /**
     * To sort the array made from single digit
     * @param inputArray : Array to be sort.
     * @param position : The position (1's, 10's ...) of the digit
     * @param radix : 10 for decimal number.
     */
    private static void radixSingleSort(int[] inputArray, int position, int radix) {

        int numOfItems = inputArray.length;
        int[] countArray = new int[radix];

        // Creating the count array.
        for (int value: inputArray) {
            countArray[getDigit(position, value, radix)] ++;
        }

        //Adjusting the count array with occurrence of digit.
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        // Storing the values to tem array
        int[] temp = new int[numOfItems];
        for (int tempIndex = numOfItems -1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, inputArray[tempIndex], radix)]] = inputArray[tempIndex];
        }

        // Copying the value from tem array to input array.
        System.arraycopy(temp, 0, inputArray, 0, numOfItems);
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }

    public static void main(String[] args) {
        int[] input = new int[]{ 4725, 4586, 1330, 8792, 1594, 5729};
        System.out.println(Arrays.toString(radixSort(input, 10, 4)));
    }
}
