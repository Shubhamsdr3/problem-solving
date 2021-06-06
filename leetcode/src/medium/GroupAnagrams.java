package medium;

import java.util.*;

public class GroupAnagrams {

    private static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            result.add(list);
            return result;
        }
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (!str.isEmpty()) {
                List<String> list = new ArrayList<>();
                list.add(str);
                int j = i+1;
                while (j < strs.length) {
                    if (isSimilar(str, strs[j])) {
                        list.add(strs[j]);
                        strs[j] = "";
                    }
                    j++;
                }
                result.add(list);
            }
        }
        return result;
    }

    /**
     * Using HashMap
     * @param strs
     * @return
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] arr = new char[26];
            for (char c: s.toCharArray()) {
                arr[c -'a']++;
            }
            String keyStr = String.valueOf(arr);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private static boolean isSimilar(String a, String b) {
        for (char c: a.toCharArray()) {
            if (!b.contains(c + "")) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        String[] arr = new String[] {
                "a"
        };
        System.out.println(groupAnagrams(arr));
    }
}
