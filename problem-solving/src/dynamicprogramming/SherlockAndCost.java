package dynamicprogramming;

public class SherlockAndCost {

    private static int cost(int[] B) {
        int[] A = new int[B.length];
        int sum = 0;
        for (int i = 1; i < B.length; i++) {
            sum = sum + Math.abs(B[i] - B[i -1]);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 1, 10, 1, 10};
        System.out.println(cost(input));
    }
}
