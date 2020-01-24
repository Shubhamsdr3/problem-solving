package strings;

public class PalindromeIndex {

    private static int palindromeIndex(String s) {
        int i=0;
        int j = s.length()-1;

        int index = -1;

        while (i < s.length() && j >0){
            if (s.charAt(i) != s.charAt(j)) {
                if (isPalindrome(s, i)) {
                    index= i;
                } else if (isPalindrome(s, j)) {
                    index = j;
                }
            }
            i++;
            j--;
        }
        return index;
    }

    private static boolean isPalindrome(String s, int index){
        for(int i =index+1,j =s.length()-1-index; i<j; i++, j--)
            if(s.charAt(i)!=s.charAt(j))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String string = "aaab";
        String string1 = "aaa";
        String string2 = "baa";
        System.out.println(palindromeIndex(string));
        System.out.println(palindromeIndex(string1));
        System.out.println(palindromeIndex(string2));
    }

}
