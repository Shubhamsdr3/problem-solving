package medium;

public class MaximumProductOfWordLengths {

    private static int maxProduct(String[] words) {
        int firstMax = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j != i && j < words.length; j++) {
                if (!contains(word, words[j])) {
                    int len = word.length() * words[j].length();
                    if (len > firstMax) {
                        firstMax = len;
                    }
                }
            }
        }
        return firstMax;
    }

    private static boolean contains(String first, String second) {
        for (char c : first.toCharArray()) {
            if (second.contains(c + "")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{
                "a","ab","abc","d","cd","bcd","abcd"
        };
        System.out.println(maxProduct(arr));
    }
}
