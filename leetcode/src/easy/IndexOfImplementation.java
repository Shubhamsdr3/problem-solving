package easy;

import java.util.Arrays;

public class IndexOfImplementation {


    private static int strStr(String haystack, String needle) {
        if (haystack.isEmpty()) {
            return 0;
        }
        char[] chars = haystack.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == needle.charAt(0)) {
                int j = 1;
                while (j < needle.length()) {
                    if (chars[i+1] != needle.charAt(j)) {
                        break;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    private static void sort(int[] arr) {
        for (int i = arr.length -1; i > 0; i--) {
            if (arr[i] < arr[i-1])  {
                int j = i -1;
                while (j >= 0 && arr[i] < arr[j]) {
                    j--;
                }
                swap(arr, i, j+1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        String str = "hello";
        String needle = "ll";
        System.out.println(strStr(str, needle));

//        int[] input = new int[]{
//                3, 5, 7, 6, 8, 9
//        };
//
//        int[] input1 = new int[]{
//                3, 8, 6, 7, 5, 9
//        };
//
//        sort(input);
    }
}
