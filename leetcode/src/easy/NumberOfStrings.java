package easy;

public class NumberOfStrings {

    private static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String str: patterns) {
            if (word.contains(str)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
       String[] arr = new String[] {"a","abc","bc","d"};
       String word = "abc";
       System.out.println(numOfStrings(arr, word));
    }
}
