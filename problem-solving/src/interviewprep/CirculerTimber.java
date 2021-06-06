package interviewprep;

public class CirculerTimber {

    public static long getTime(String s) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum = sum + c - 'A';
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "BZA";
        System.out.println(getTime(str));
    }
}
