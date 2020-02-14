import java.util.Scanner;

public class QuickMatch21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = 3;
            int[] arr = new int[]{6, 4, 1};
            for (int i=0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int j = arr.length -1;
            while (j > 0) {
                System.out.print(arr[j] + " ");
                j--;
            }
        }
    }
}
