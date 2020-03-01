package Uwcoi2020;

public class BasePlan {

    //FIXME:SHUBHAM
    private static int findSquare(String[] arr, int n) {
        int count = 1;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length(); col++) {
                if (arr[row].charAt(col) == '1') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        String[] arr = new String[]{"1000", "0010", "0100", "0001"};
        System.out.println(findSquare(arr, n));
    }
}
