package greedyalgorithm;

import java.util.Arrays;

public class GridChallenge {

    private static String gridChallenge(String[] grid) {
        if (grid.length == 1) {
            return "YES";
        }
        String[] resultArray = new String[grid.length];
        for (int i = 0; i< grid.length; i++) {
            String firstRow = grid[i]; // row of leetcode.string
            char[] chars = firstRow.toCharArray();
            Arrays.sort(chars);
            StringBuilder stringBuilder = new StringBuilder();
            for (char c: chars) {
                stringBuilder.append(c);
            }
            resultArray[i] = stringBuilder.toString();
        }

        String result = "";
        for (int k=0; k < resultArray.length -1; k++) {
            String firstRow = resultArray[k];
            String secondRow = resultArray[k + 1];
            for (int n = 0; n < firstRow.length() -1; n++) {
                if (secondRow.charAt(n) >= firstRow.charAt(n)) {
                    result = "YES";
                } else {
                    result = "NO";
                    break;
                }
            }
            if (result.equals("NO")) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] stringArray = new String[]{"l"};
        System.out.println(gridChallenge(stringArray));
    }
}
