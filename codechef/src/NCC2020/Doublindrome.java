package NCC2020;

import java.util.Scanner;

public class Doublindrome {

    private static String checkDoublinDrome(int n, String string)  {
        int mid = n/2;
        if (isPalindrome(string.substring(0, mid)) && isPalindrome(string.substring(mid)))  {
            return "YES";
        }
        return "NO";
    }

    private static boolean isPalindrome(String string) {
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

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while (sc.hasNext()) {

            int testCases = sc.nextInt();
            while (testCases > 0) {
                int n = sc.nextInt();
                String string = sc.next();
                System.out.println(checkDoublinDrome(n, string));
                testCases--;
            }
        }
    }
}
