package implementation;

import java.util.Scanner;

public class MansaAndStone {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        int sum = 0;
        for (int i=0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            sum = sum + arr[i];
        }

        int count = 0;
        if (sum % 2 ==1) {
            System.out.println("NO");
        } else {
            for (int i=0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    arr[i] = arr[i] + 1;
                    count++;
                    arr[i+1] = arr[i +1] +1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
