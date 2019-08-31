import java.util.Arrays;

public class ReplaceNumber {

    public static void replaceNumber(int number) {
        int[] arr = new int[number];
        for (int i=0; i < number; i++) {
            arr[i] = i + 1;
        }
        for (int j = 0; j < arr.length; j++ ) {
            if (j % 3 == 0) {
                arr[j] = 'p';
            } else if (j % 5 == 0){
                arr[j] = 't';
            } else if (j % 15 == 0) {
                arr[j] = 'h';
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        replaceNumber(20);
    }
}


