package Feblunchtime2020;

import java.util.Scanner;

public class SwappingToPalindrome {

    private static void swapToPalindrome(String str, int n) {
        int i =0;
        int j = str.length()-1;
        int k = i+1;
        int count = 0;
        while (i < str.length() && j >= 0 && k < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                str = swap(str.toCharArray(), i, k);
                count++;
                if (isPalindrome(str)) {
                    System.out.println("YES");
                    System.out.println(count);
                    return;
                }
                i++;
                j--;
            }
            k = i+1;
        }
        System.out.println("NO");
    }
    private static  boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (sb.reverse().toString().equals(str)) {
            return true;
        }
        return false;
    }

    private static String swap(char[] arr, int i, int j) {
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int test = sc.nextInt();
            while (test > 0) {
                int n = sc.nextInt();
                String str = sc.next();
                swapToPalindrome(str, n);
                test--;
            }

        }
    }
}
