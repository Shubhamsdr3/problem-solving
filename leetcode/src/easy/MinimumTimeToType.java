package easy;

public class MinimumTimeToType {

    private static int minTimeToType(String word) {
        int count = word.length(); // every character takes 1 sec to type.
        char prev = 'a';
        for (int i = 0; i < word.length(); ++i) {
            char curr = word.charAt(i);
            int diff = Math.abs(curr - prev);
            count = count + Math.min(diff, 26 - diff);
            prev = curr;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToType("bza"));
    }
}
