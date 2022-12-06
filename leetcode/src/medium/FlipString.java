package medium;

/**
Created at: 19/11/22
*/
public class FlipString {

    private static int minFlipsMonoIncreasing(String str) {
        int countOne = 0;
        int countZero = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                countOne++;
            } else {
                countZero++;
            }
            countZero = Math.min(countOne, countZero);
        }
        return countZero;
    }

    public static void main(String[] args) {
        String str = "0101100011";
        System.out.println(minFlipsMonoIncreasing(str));
    }
}
