package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {


    /**
     * Using HashTable
     * @param s
     * @param p
     * @return
     */

    private static List<Integer> findAnagramsUsingHT(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[26];
        int[] phash = new int[26];
        int window = p.length();
        int len = s.length();
        if (len < window) {
            return list;
        }
        int left = 0;
        int right = 0;
        while (right < window) {
            phash[p.charAt(right) - 'a']++;
            hash[s.charAt(right) - 'a']++;
            right++;
        }
        right--;
        while (right < len) {
            if (areArrayEquals(hash, phash)) {
                list.add(left);
            }
            right++;
            if (right != len) {
                hash[s.charAt(right) - 'a']++;
            }
            hash[s.charAt(left) - 'a']--;
            left++;
        }
        return list;
    }

    private static boolean areArrayEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = p.length();
        while (i < s.length() && j <= s.length()) {
            String subString = s.substring(i, j);
            if (areEquals(subString, p)) {
                list.add(i);
            }
            i++;
            j++;
        }
        return list;
    }

    private static boolean areEquals(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < s1.length(); i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagramsUsingHT(s, p));
    }
}
