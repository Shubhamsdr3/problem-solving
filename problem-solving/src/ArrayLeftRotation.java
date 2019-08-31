import java.util.Arrays;

public class ArrayLeftRotation {

    private static int[] rotateLeft(int[] arr, int numberOfRotations) {
        while (numberOfRotations > 0) {
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
            numberOfRotations --;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotateLeft(input, 4)));
    }
}
