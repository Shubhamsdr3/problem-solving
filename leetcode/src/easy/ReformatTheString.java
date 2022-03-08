package easy;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString {

    private static String reformat(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        List<Character> characters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) < '9') {
                characters.add(s.charAt(i));
            } else if (s.charAt(i) >= 'a' && s.charAt(i) < 'z') {
                digits.add(s.charAt(i));
            }
        }
        if(Math.abs(digits.size() - characters.size()) >= 2) return "";
        StringBuilder sb = new StringBuilder();
        boolean digitOrChar = digits.size() >= characters.size();
        for (int i =0; i < s.length(); i++) {
            if (digitOrChar) {
                if (digits.size() > 0) {
                    sb.append(digits.remove(0));
                }
            } else  {
                if (characters.size() > 0) {
                    sb.append(characters.remove(0));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reformat(str));
    }
}
