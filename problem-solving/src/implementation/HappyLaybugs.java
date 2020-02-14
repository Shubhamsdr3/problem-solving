package implementation;

public class HappyLaybugs {

    private static String happyLadybugs(String b) {
        String res = "";
        for (int i = 0; i < b.length() -1; i++) {
           if (b.charAt(i+1) == '_') {
               for (int j = i+2; j < b.length(); j++) {
                   if (b.charAt(i) == b.charAt(j)) {
                      res = swap(b.toCharArray(), i+1, j);
                      System.out.println(res);
                   }
               }
           }
        }
        for (int i = b.length() -1; i > 0; i--) {
            if (b.charAt(i-1) == '_') {
                for (int j = i-2; j > 0; j--) {
                    if (b.charAt(i+1) == b.charAt(j)) {
                        res = swap(b.toCharArray(), i, j);
                    }
                }
            }
        }
        return res;
    }

    private static String swap(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch: chars) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string = "RBY_YBR";
        System.out.println(happyLadybugs(string));
    }
}