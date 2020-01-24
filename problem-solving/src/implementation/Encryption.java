package implementation;

import java.util.ArrayList;
import java.util.List;

public class Encryption {

    private static String encryption(String s) {
        System.out.println(System.currentTimeMillis());
        String removedSpaces = removeSpaces(s);
        double length = removedSpaces.length();
        int cols = (int) Math.ceil(Math.sqrt(length));
        int rows = (int) Math.floor(Math.sqrt(length));

        List<String> stringArray = new ArrayList<>();
        if (rows * cols < length) {
            if (rows < cols) {
                rows++;
            } else {
                cols++;
            }
        }

        int i=0;
        int j = cols;
        while (j <= length) {
            stringArray.add(s.substring(i, j));
            i = j;
            j = j + cols;
            if (j >= length) {
                stringArray.add(s.substring(i, (int)length));
                break;
            }
        }

        int col = 0;
        while (col < cols) {
            StringBuilder sb = new StringBuilder();
            for (int k=0; k < stringArray.size(); k++) {
                if (col < stringArray.get(k).length()) {
                    sb.append(stringArray.get(k).charAt(col));
                    System.out.print(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
            System.out.println();
            col++;
        }
        System.out.println(System.currentTimeMillis());
        return "";
    }

    private static String removeSpaces(String str) {
        StringBuilder stringBuilder  = new StringBuilder();
        for (int i=0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string1= "haveaniceday";
        String string2 = "feedthedog";
        String string3 = "chillout";
//        encryption(string1);
//        encryption(string2);
        encryption(string3);
    }
}
