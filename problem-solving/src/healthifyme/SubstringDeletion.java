package healthifyme;

public class SubstringDeletion {

    private static long solve(String str) {
        int i = 0;
        int j = i+1;
        String finalStr = str;
        while (i < j && j < str.length()) {
            String subString = str.substring(i, j);
            String remaining = str.substring(j);
            if (remaining.contains(subString)) {
                remaining.replace(subString, "");
            }
            i++;
            j++;
        }
        System.out.println(finalStr);

        return 0;
    }

    public static void main(String[] args) {
        String str = "abcc";
        System.out.println(solve(str));
    }
}
