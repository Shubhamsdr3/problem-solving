package strings;

public class RepeatedString {

    private static long repeatedString(String s, long n) {
        if (!s.contains("a")) {
            return 0;
        }
        if (s.length() == 1 && s.charAt(0) == 'a') {
            return n;
        }
        if (s.length() >= n) {
            return getCount(s.substring(0, (int) n));
        }
        int aCount = getCount(s);
        long count = aCount;
        int len = s.length();
        long length = s.length();
        while (true) {
            length = length + len;
            if (length < n) {
                count = count + aCount;
            } else {
                long diff = n - length;
                String str;
                if (diff > 0 && diff < s.length()) {
                    str = s.substring(0, (int) diff);
                } else {
                    str = s;
                }
                count = count + getCount(str);
                return count;
            }
        }
    }

    private static long repeatedString1(String str, long n) {
        long numberOfReps = n / str.length();
        long remainder = n % str.length();
        long total = 0;
        for (char c: str.toCharArray()) {
            if (c == 'a') {
                total++;
            }
        }
        total = total * numberOfReps;
        for(int a = 0; a < remainder; a++){
            if(str.charAt(a) == 'a'){
                total++;
            }
        }
        return total;
    }

    private static int getCount(String str) {
        int count = 0;
        for (char c: str.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "afcfffaged";
        long n = 962645758455L;
        System.out.println(repeatedString1(str, n));
    }
}
