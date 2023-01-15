package strings;

import java.util.*;

public class AnagramSubStringSearch {


    private  static List<Integer> anagramSearchUsingHasMap(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = pat.charAt(i);
            wordCount.put(ch, wordCount.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < n - m; i++) {
            Map<Character, Integer> wordCount2 = new HashMap<>();
            for (int j = i; j < i + m; j++) {
                char ch = pat.charAt(j);
                wordCount2.put(ch, wordCount2.getOrDefault(ch, 0) + 1);
            }
            if (isAnagram(wordCount, wordCount2)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isAnagram(Map<Character, Integer> wordCount1, Map<Character, Integer> wordCount2) {
        for (char ch: wordCount1.keySet()) {
            if (!wordCount1.get(ch).equals(wordCount2.get(ch))) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param s
     * @param pat
     * @return
     */
    private  static List<Integer> anagramSearchImproved(String s, String pat) {
        List<Integer> list = new ArrayList<>();
        if (pat.length() > s.length()) return list; // if pattern is greater than the string itself.
        int n = s.length();
        int m = pat.length();
        int[] countS = frequency(pat);
        int[] currentCount = frequency(s.substring(0, m));
        if (areEquals(countS, currentCount)) {
            list.add(0);
        }
        for (int i = m; i < n; i++) {
            currentCount[s.charAt(i - m) - 'a']--; // remove the previous character from the window.
            currentCount[s.charAt(i) - 'a']++; // add new character to the window
            // now check if both are same
            if (areEquals(countS, currentCount)) {
                list.add(i - m + 1);
            }
        }
        return list;
    }

    private static boolean areEquals(int[] arr1, int[] arr2) {
       for (int i = 0; i < 26; i++) {
           if (arr1[i] != arr2[i]) {
               return false;
           }
       }
       return true;
    }

    private static int[] frequency(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    // input string = "BACDGABCDA"
    // patter = "abcd"
    // T.C ->  O(mlogm) + O( (n-m+1)(m + mlogm + m) )
    // Space -> O(m)
    private static List<Integer> anagramSearch(String s, String pattern) {
        // sort the pattern
        char[] chars = pattern.toCharArray();
        Arrays.sort(chars);
        String str = String.valueOf(chars);
        int i = 0;
        int j = pattern.length();
        List<Integer> result = new ArrayList<>();
        while (i < s.length() && j < s.length()) {
            String subString = s.substring(i, j);
            char[] temp = subString.toCharArray();
            Arrays.sort(temp);
            String pat = String.valueOf(temp);
            if (pat.equals(str)) {
                result.add(i);
            }
            i++;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "cbaebabacd";
        String pat = "abc";
//        System.out.println(anagramSearchImproved(str, pat));
        System.out.println(anagramSearchUsingHasMap(str, pat));
    }
}
