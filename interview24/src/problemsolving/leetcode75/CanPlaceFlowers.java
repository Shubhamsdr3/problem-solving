package problemsolving.leetcode75;

public class CanPlaceFlowers {

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (prev == 0 & next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n==0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 0, 0, 0, 1 };
        int n = 2;

        int[] arr1 = new int[] { 1,0,0,0,0,1 };
        int n1 = 2;

        int[] arr2 = new int[] { 0,0,1,0,0 };
        int n2 = 1;

        System.out.println(canPlaceFlowers(arr2, n2));
    }
}
