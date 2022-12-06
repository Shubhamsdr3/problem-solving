package hard;

public class ShortestPalindrome {

    private static String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse();
        int[] table = getTable(temp);
        //get the maximum palindrome part in s starts from 0
        return new StringBuilder(s.substring(table[table.length -1])).reverse() + s;
    }

    private static int[] getTable(String temp) {
        int[] table = new int[temp.length()];
        int index = 0;
        int m = temp.length();
        int i = 1;
        while (i < m) {
            if (temp.charAt(index) == temp.charAt(i)) {
                table[i] = ++index;
                i++;
            } else  {
                if (index > 0) {
                    index = table[index -1];
                } else {
                    index = 0;
                    i++;
                }
            }
        }
        return table;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "aacecaaa";
        String s3 = "aabba";
        String s4 = "adcba";
        System.out.println(shortestPalindrome(s1));
    }
}
