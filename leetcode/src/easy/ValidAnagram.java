package easy;

public class ValidAnagram {

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
        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s, t));
    }
}
