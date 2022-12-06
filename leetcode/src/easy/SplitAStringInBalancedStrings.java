package easy;

public class SplitAStringInBalancedStrings {

    private static int balancedStringSplit(String s) {
        int i = 0;
        int j = i + 1;
        int totalCount = 0;
        while (i < s.length() && j < s.length()) {
            String subString = s.substring(i, j + 1);
            int countR = 0;
            int countL = 0;
            for (char c: subString.toCharArray()) {
                if (c == 'R') {
                    countR++;
                } else if (c == 'L') {
                    countL++;
                }
            }
            if (countL == countR) {
                totalCount++;
                i = j + 1;
            }
            j++;
        }
        return totalCount;
    }

    private static int balanceStringSplit1(String str){
        int res = 0;
        int count  = 0;
        for (char c: str.toCharArray()) {
            if (c == 'L') {
                count++;
            } else {
                count--;
            }
            if (count == 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "RLRRLLRLRL";
        String str1 = "RLLLLRRRLR";
        String str2 = "LLLLRRRR";
        System.out.println(balanceStringSplit1(str));
        System.out.println(balanceStringSplit1(str1));
        System.out.println(balanceStringSplit1(str2));
    }
}
