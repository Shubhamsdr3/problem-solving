import java.util.Arrays;

public class SparseArray {

    private static int[] matchingStrings(String[] strings, String[] queries){
        int[] countArray =  new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (String value2: strings) {
                if (queries[i].equals(value2)) {
                    countArray[i] ++;
                }
            }
        }
        return countArray;
    }

    public static void main(String[] args) {
        String[] inputArray = new String[]{"aba", "baba", "aba", "x2xb"};
        String[] queries = new String[]{"aba", "x2xb", "ab"};
        System.out.println(Arrays.toString(matchingStrings(inputArray, queries)));
    }
}
