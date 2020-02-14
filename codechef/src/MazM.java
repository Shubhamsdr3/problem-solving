import java.util.Scanner;

public class MazM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i=0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            for (int k=0; k < arr.length; k++) {
                int num = arr[k];
                for (int j=0; j < arr.length; j++) {
                    if ((j+1) % 2 == 0) {
                        arr[j] = arr[j] - num;
                    } else {
                        arr[j] = arr[j]  + num;
                    }
                }

                if (arr[k] < arr[k+1]) {
                    System.out.println(num);
                }
            }
        }
    }
}
