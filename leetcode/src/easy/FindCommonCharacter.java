package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacter {

    // [bella","label","roller] -> ["e", "l", "l"]
    // ["cool","lock","cook"] -> ["c","o"]
    private static List<String> commonChars(String[] A) {
        String firstString = A[0];
        List<String> list = new ArrayList<>();
        for (int i=0; i< firstString.length(); i++) {
            boolean isContains = true;
            for (int j =1;  j < A.length; j++) {
                if (!A[j].contains(firstString.charAt(i) + "")) {
                    isContains = false;
                }
                A[j] = removeCharacter(A[j], firstString.charAt(i));
            }

            if (isContains) {
                list.add(firstString.charAt(i) + "");
            }
        }
        return list;
    }

    private static String removeCharacter(String string, char c) {
        StringBuilder sb =  new StringBuilder(string);
        for (int i =0; i< string.length(); i++) {
            if (string.charAt(i) == c) {
                sb.deleteCharAt(i);
                break;
            }
        }
        return sb.toString();
    }


    public List<String> commonChars1(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
            for (int i = 0; i < 26; ++i) {
                count[i] = Math.min(cnt[i], count[i]); // update minimum frequency.
            }
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                ans.add("" + c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr =  new String[]{"bella","label","roller"};
        String[] arr1 =  new String[]{"cool","lock","cook"};
        System.out.println(commonChars(arr));
        System.out.println(commonChars(arr1));
    }
}
