package medium;

public class FlipString {

    private static int minFlipsMonoIncr(String S) {
        int numberOfZero = 0;
        int numberOfOne = 0;
        for (int i =0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                numberOfOne++;
            } else {
                numberOfZero++;
            }
        }
        if (numberOfOne == numberOfZero) {
            return flipCharacter(S);
        } else if (numberOfZero > numberOfOne) {
            for (int i=0; i < S.length(); i++) {
                if (S.charAt(i) == '1') {

                }
            }
        }
        return 0;
    }

    private static int flipCharacter(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder(str);
        for (int i=0; i < str.length(); i++) {
            if (sb.charAt(i) == '1') {
                for (int j = i; j < str.length(); j++) {
                    if (sb.charAt(j) == '0') {
                        sb.replace(j, j+1, "1");
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "01011001";
        System.out.println(minFlipsMonoIncr(str));
    }
}
