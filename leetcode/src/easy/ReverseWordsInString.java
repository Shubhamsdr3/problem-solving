package easy;

public class ReverseWordsInString {

    private static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] arr = s.split(" ");
        for (String str: arr) {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            res.append(sb.toString());
            res.append(" ");
        }
        return res.toString();
    }

//    private static String reverseCharacters(String str) {
//
//    }

    public static void main(String[] args) {
     String str = "Let's take LeetCode contest";
     System.out.println(reverseWords(str));
    }

}
