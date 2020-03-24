package medium;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagram {

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalList = new ArrayList<>();
        if (strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            finalList.add(list);
            return finalList;
        }
        for (int i =0; i < strs.length; i++) {
            if (!strs[i].equals("A")) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                for (int j = i+1; j < strs.length; j++) {
                    if (!strs[j].equals("A") && isAnagram(strs[i], strs[j])) {
                        list.add(strs[j]);
                        strs[j] = "A";
                    }
                }
                finalList.add(list);
            }
        }
        return finalList;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count =  new int[26];
        for (int i =0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i=0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int item: count) {
            if (item > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] arr1 = new String[]{"a"};
        System.out.println(groupAnagrams(arr1));
    }
}
