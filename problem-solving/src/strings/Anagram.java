package strings;

public class Anagram {

    /**
     * TC:  O(n2)
     * @param s
     * @return
     */
    private static int anagram(String s) {
        int count = 0;
        if (s.length() % 2 == 0) {
            String string1 = s.substring(0, s.length()/2);
            String string2 = s.substring(s.length()/2);
            StringBuilder stringBuilder = new StringBuilder(string2);
            for (int i = 0; i < string1.length(); i++) {
                boolean isFound = false;
                for (int j=0; j < stringBuilder.length(); j++) {
                    if (string1.charAt(i) == stringBuilder.charAt(j)) {
                        isFound = true;
                        stringBuilder.deleteCharAt(j);
                        break;
                    }
                }
                if (!isFound) {
                    count++;
                }
            }
        } else {
            return -1;
        }
        return count;
    }

    /**
     * TC: O(n)
     * @param s
     * @return
     */
    private static int anagram1(String s) {
        int count = 0;
        if (s.length() % 2 == 0) {
            String string1 = s.substring(0, s.length()/2);
            String string2 = s.substring(s.length()/2);
            char[] stringChars = string1.toCharArray();

            for (char c: stringChars) {
                int index = string2.indexOf(c);
                if (index == -1) {
                    count++;
                } else {
                    string2 = string2.substring(0,index) + string2.substring(index+1);
                }
            }
        } else {
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        String string = "aaabbb";
        String string1 = "ab";
        String string2 = "abc";
        String string3 = "mnop";
        String string4 = "xyyx";
        String string5 = "fdhlvosfpafhalll";
//        System.out.println(anagram(leetcode.string));
//        System.out.println(anagram(string1));
//        System.out.println(anagram(string2));
//        System.out.println(anagram(string3));
//        System.out.println(anagram(string4));
        System.out.println(anagram1(string5));
    }
}
