package medium;

/**
Created at: 05/10/22
*/
public class MaximumPointsYouCanObtain {

    // fix me
    private static int maxScore(int[] cardPoints, int k) {
        int start = 0;
        int end = cardPoints.length - 1;
        int sum = 0;
        while (start <= end && k > 0)  {
            if (cardPoints[start] > cardPoints[end]) {
                sum = sum + cardPoints[start];
                start++;
            } else  {
                sum = sum + cardPoints[end];
                end--;
            }
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 49, 100, 86, 29, 72};
        int k = 4;
        System.out.println(maxScore(arr, k));
    }
}
