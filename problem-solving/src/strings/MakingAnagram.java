package strings;

import java.util.*;

public class MakingAnagram {

    private static int makingAnagrams(String s1, String s2) {
        int count = 0;
        int totalLength = s1.length() + s2.length();

        StringBuilder stringBuilder = new StringBuilder(s2);

        for (int i = 0; i < s1.length(); i++) {
            boolean isFound = false;
            for (int j=0; j < stringBuilder.length(); j++) {
                if (s1.charAt(i) == stringBuilder.toString().charAt(j)) {
                    isFound = true;
                    stringBuilder.deleteCharAt(j);
                    break;
                }
            }
            if (isFound) {
                count = count + 2;
            }
        }
        return totalLength - count;
    }

    /**
     * Optimized: O(max(s1.length(), s2.length())
     * @param s1
     * @param s2
     * @return
     */
    private static int makingAnagrams1(String s1, String s2) {
        int count = 0;
        int[] chars = new int[26];
        for (int i=0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 97]++;
        }
        for (int i=0; i < s2.length(); i++) {
            chars[s2.charAt(i) - 97]--;
        }
        for(int i: chars) {
            count += Math.abs(i);
        }
        return count;
    }

    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "amnop";

        String string3 = "absdjkvuahdakejfnfauhdsaavasdlkj";
        String string4 = "djfladfhiawasdkjvalskufhafablsdkashlahdfa";
        System.out.println(makingAnagrams1(string3, string4));
    }
}
