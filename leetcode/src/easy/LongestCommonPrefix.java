package easy;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    // My brute force approach (:
    private static String longestCommonPrefix(String[] strs) {
        if (strs== null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String str = strs[0];
        int i=0;
        boolean isLcsExist = false;
        StringBuilder sb = new StringBuilder();
        while (i < str.length()) {
            char c = str.charAt(i);
            boolean isEqualInAll = true;
            for (int j=1; j < strs.length; j++) {
                if (i < strs[j].length() && c != strs[j].charAt(i)) {
                    isEqualInAll = false;
                }
            }
            if (isEqualInAll) {
                sb.append(c);
                isLcsExist = true;
            } else {
                break;
            }
            i++;
        }
        if (isLcsExist) {
            return sb.toString();
        }
        return "";
    }

    private static String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0,pre.length()-1);
            }
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"flower","flow","flight"};
        String[] arr1 = new String[]{"dog","racecar","car"};
        String[] arr2 = new String[]{"c","acc","ccc"};
        String[] arr3 = new String[]{"aca","cba"};
//        System.out.println(longestCommonPrefix(arr));
//        System.out.println(longestCommonPrefix(arr1));
        System.out.println(longestCommonPrefix(arr));
    }
}
