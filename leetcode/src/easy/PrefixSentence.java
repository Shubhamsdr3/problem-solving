package easy;

public class PrefixSentence {

    private static int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.startsWith(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String sent = "i am tired";
        String searchWord = "you";
        System.out.println(isPrefixOfWord(sent, searchWord));
    }
}
