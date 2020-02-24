package easy;

public class DetectCapital {

    private static boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "Google";
        String word1 = "USA";
        String word2 = "FlaG";
        System.out.println(detectCapitalUse(word));
        System.out.println(detectCapitalUse(word1));
        System.out.println(detectCapitalUse(word2));
    }
}
