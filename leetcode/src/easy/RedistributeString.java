package easy;

public class RedistributeString {

    private static boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        for (String word: words) {
            for (int i =0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
        }
        for (int val : freq) {
            if (val > 0 && val % words.length != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input = new String[]{ "abc","aabc","bc" };
        System.out.println(makeEqual(input));
    }
}
