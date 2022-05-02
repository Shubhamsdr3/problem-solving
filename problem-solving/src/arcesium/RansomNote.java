package arcesium;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {

    private static void checkMagazine(List<String> magazine, List<String> note) {
        boolean isExist = false;
        for (String word: note) {
            for (int j = 0; j < magazine.size(); j++) {
                if (magazine.get(j).equals(word)) {
                    isExist = true;
                    magazine.set(j, "");
                }
            }
        }
        if (isExist) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        List<String> magazine = new ArrayList<>();
        magazine.add("two");
        magazine.add("times");
        magazine.add("three");
        magazine.add("is");
        magazine.add("not");
        magazine.add("four");

        List<String> note = new ArrayList<>();
        note.add("two");
        note.add("times");
        note.add("two");
        note.add("is");
        note.add("four");
        checkMagazine(magazine, note);
    }
}
