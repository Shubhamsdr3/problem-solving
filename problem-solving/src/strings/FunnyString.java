package strings;

public class FunnyString {

    private static String funnyString(String s) {
        String result = "Funny";
        int i=1;
        int j = s.length()-1;
        while (i < s.length() && j > 0) {
            int diff1 = Math.abs(s.charAt(i) - s.charAt(i - 1));
            int diff2 = Math.abs(s.charAt(j) - s.charAt(j -1));
            if (diff1 != diff2) {
                result = "Not Funny";
                break;
            }
            i++;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "fmpszyvqwxrtvpuwqszvyvotmsxsxuvzyvpwzrpmuxqwtswvytytzsnuxuyrpvtysqoutzurqxury";
        String string1 = "ivvkx";
        String string2 = "nosklrxrtyuxtmnurzsryuxtywqwqpxts";
        String string3 = "pryumtuntmovpwvowslj";
//        System.out.println(funnyString(leetcode.string));
//        System.out.println(funnyString(string1));
//        System.out.println(funnyString(string2));
        System.out.println(funnyString(string3));
    }
}
