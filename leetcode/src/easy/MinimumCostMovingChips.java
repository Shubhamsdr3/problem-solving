package easy;

public class MinimumCostMovingChips {

    private static int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int pos: position) {
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 3, 3};
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 1000000000};
        int[] arr3 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        System.out.println(minCostToMoveChips(arr3));
    }
}
