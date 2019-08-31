import java.util.Arrays;
import java.util.stream.IntStream;

public class ClimbingLeaderBoard {

    private static int[] climbingLeaderBoard(int[] scores, int[] alice) {
        int[] distinctArray = IntStream.of(scores).distinct().toArray();
        int rank = distinctArray.length - 1;
        int[] result = new int[alice.length];
        int index = 0;
        for (int score: alice) {
            while (rank >= 0) {
                if (score >= distinctArray[rank]) {
                    rank --;
                } else {
                    result[index] = rank + 2;
                    index ++;
                    break;
                }
            }
            if (rank < 0) {
                result[index] =1;
                index ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] scores = new int[]{100, 100, 50, 40, 40, 20, 10};
        int[] alice = new int[]{5, 25, 50, 120};
        int[] result = climbingLeaderBoard(scores, alice);
        System.out.println(Arrays.toString(result));
    }
}
