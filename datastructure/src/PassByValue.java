import java.util.Arrays;

public class PassByValue {

    private static void printValue(int number) {
        System.out.println(number);
        number = 100; // It last only in method. does not change outside value.
        System.out.println(number);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
        arr[0] = 100; // It will change the value of array outside of this method.
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int number = 25;
        int[] array = new int[]{12, 23, 45, 56};
        printValue(number);
        printArray(array);
        System.out.println(number);
        System.out.println(Arrays.toString(array));
    }
}
