package easy;

public class FindTheKBeauty {

    private static int divisorSubstrings(int num, int k) {
        int i = 0;
        int j = i + k - 1;
        String numString = String.valueOf(num);
        int count = 0;
        while (i < numString.length() && j < numString.length()) {
            String value = numString.substring(i, j + 1);
            int numValue = Integer.parseInt(value);
            if (numValue != 0 && num % numValue == 0) {
                count++;
            }
            i++;
            j = i + k - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 240;
        int k = 2;
        System.out.println(divisorSubstrings(num, k));
    }
}
