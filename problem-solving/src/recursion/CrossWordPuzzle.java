package recursion;

import java.util.Arrays;

public class CrossWordPuzzle {

    private static String[] crosswordPuzzle(String[] crossword, String words) {
        String[] result = new String[crossword.length];
        int i = 0;
        int index = 0;
        while (i < words.length()) {
            if (words.charAt(i) <= 'Z' && words.charAt(i) >= 'A') {
                for (int j=0; j < crossword.length; j++) {
                    String string = crossword[j];
                    int k = 0;
                    while (k < string.length()) {
                        if (string.charAt(k) == '-') {
                            result[index] = string.replace('-', words.charAt(i));
                            i++;
                            break;
                        }
                        k++;
                    }
                    index++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "LONDON;DELHI;ICELAND;ANKARA";
        String[] inputStrings = new String[]
                {
                        "+-++++++++", "+-++++++++", "+-++++++++", "+-----++++", "+-+++-++++",
                        "+-+++-++++", "+++++-++++", "++------++", "+++++-++++", "+++++-++++"
                };
        System.out.println(Arrays.toString(crosswordPuzzle(inputStrings, string)));
    }
}
