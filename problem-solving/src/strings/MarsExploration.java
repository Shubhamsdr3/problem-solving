package strings;

public class MarsExploration {

    private static int marsExploration(String s) {
        int count = 0;
        String pattern = "SOS";
        for (int i=0;  i < s.length(); i++) {
            if (s.charAt(i) != pattern.charAt(i %  3)) { // The catch is: i % 3
                count++;
            }
//            if (i == pattern.length() -1) {
//                pattern = pattern + pattern;
//            }
        }
        return count;
    }

    public static void main(String[] args) {
        String string = "SOSSPSSQSSOR";

        String string1 = "SOSSOT";

        String string2 = "SOSSOSSOS";

        String string4 = "QQQ";

        String string3 = "SOSOSOSOSDSDSKWOSDOSDOASDOASDFAFJDFDOSOSOWNSOSOSNDSKDDOSOSOSJDSDSOOSOSDSDOSASSOASDSAOSOSODSDSOASDWS";

        String str5 = "PPPQQQGGGGGGGGGGGGGGGMMMMMMMMMFFFFFFDDDERT";

        System.out.println(marsExploration(str5));
    }
}
