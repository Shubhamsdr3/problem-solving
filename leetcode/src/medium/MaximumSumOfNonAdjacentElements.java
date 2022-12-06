package medium;

public class MaximumSumOfNonAdjacentElements {

    private static int findMaxSumOfNonAdjacent(int[] arr) {
        int inc = arr[0];
        int exc = 0;
        for (int i = 1; i < arr.length; i++) {
            int newInc = exc + arr[i];
            int newExc = Math.max(inc, exc);
            inc = newInc;
            exc = newExc;
        }
        return Math.max(inc, exc);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 5, 10, 10, 100, 6};
        System.out.println(findMaxSumOfNonAdjacent(arr));
    }
}
