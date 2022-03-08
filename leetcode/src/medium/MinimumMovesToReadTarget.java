package medium;

public class MinimumMovesToReadTarget {

    private static int minMoves(int target, int maxDoubles) {
        int step = 0;
        while (target > 1) {
            if (target % 2 == 0 && maxDoubles > 0) {
                target = target /2;
                maxDoubles--;
            } else {
                target--;
            }
            step++;
        }
        return step + target -1;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(764138259, 1));
    }
}
