package hackerearth.febcircuits20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PallindromeNumber {

    private static boolean reverseInteger1(int num) {
        String string = String.valueOf(num);
        if (string.length() == 1) {
            return true;
        }
        int i = 0;
        int j = string.length()-1;
        while (i < string.length() && j > 0) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static int reverseInteger(int num) {
        int remainder;
        int reversedInteger = 0;
        while( num != 0 ) {
            remainder = num % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            num  /= 10;
        }
        return reversedInteger;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase > 0) {
            String readLine = br.readLine();
            String[] arr = readLine.split(" ");
            int x = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);
            int i = x;
            int count = 0;
            while (true) {
                if (reverseInteger1(i)) {
                    count++;
                }
                if (count == k) {
                    System.out.println(i);
                    break;
                }
                i++;
            }
            testCase--;
        }
    }
}
