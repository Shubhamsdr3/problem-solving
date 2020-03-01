package Uwcoi2020;

import java.util.Scanner;

public class ButtonPairs {

    // [3, 5, 3, 4] -> 3 odd pair
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
           int test = scanner.nextInt();
           while (test > 0) {
               int numberOfButtons = scanner.nextInt();
               if (numberOfButtons == 1 && scanner.nextInt() % 2 == 0) {
                   System.out.println(0);
                   return;
               }
               int[] arr = new int[numberOfButtons];
               for (int i=0; i <= numberOfButtons; i++) {
                  arr[i] = scanner.nextInt();

               }
               int count = 0;
               for (int i=0; i < arr.length; i++) {
                   for (int j =i+1; j < arr.length; j++) {
                       if ((arr[i] + arr[j]) % 2 != 0) {
                           count++;
                       }
                   }
               }
               System.out.println(count);
               test--;
           }
        }
        scanner.close();
    }
}
