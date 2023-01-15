package easy;

public class LongestCommonPrefix {

    // My brute force approach (:
    private static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return sb.toString();
        }
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        for (int i = 0; i < minLen; i++) {
            char current = strs[0].charAt(i);
            for (String str: strs) {
                if (str.charAt(i) != current) {
                    return sb.toString();
                }
            }
            sb.append(current);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"flower","flow","flight"};
        String[] arr1 = new String[]{"dog","racecar","car"};
        String[] arr2 = new String[]{"c","acc","ccc"};
        String[] arr3 = new String[]{"aca","cba"};
        System.out.println(longestCommonPrefix(arr));
        System.out.println(longestCommonPrefix(arr1));
        System.out.println(longestCommonPrefix(arr2));
    }
}
