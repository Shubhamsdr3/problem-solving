package leetcode75.binarysearch;

public class KoKoEatingBananas {

    private static int minEatingSpeed(int[] piles, int h) {
        int low = 1; // assuming this is the minimum banana KoKo can eat in an hr.
        int high = getMax(piles); // this is max one she can eat.
        while (low <= high) {
            int k = low + (high - low) / 2; // get the median.
            if(canEatAllBananas(k, piles, h)) {
                high = k - 1; // bcz we need minimum value.
            } else {
                low = k + 1; // increase the k value.
            }
        }
        return low;
    }

    private static boolean canEatAllBananas(int numberPerHr, int[] piles, int h) {
        int countHr = 0;
        for (int banana: piles) {
            countHr = countHr + (banana / numberPerHr);
            if(banana % numberPerHr != 0) {
                // if there is any banana remaining in that hr then there will need another hr to finish.
                countHr++;
            }
        }
        return countHr <= h;
    }

    private static int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int banana: piles) {
            if (banana > max) {
                max = banana;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 6, 7, 11 };
        int h = 8;
        System.out.println(minEatingSpeed(arr, h));
    }
}
