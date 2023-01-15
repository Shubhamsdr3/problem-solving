package medium;

import java.util.ArrayList;
import java.util.List;

public class AllDivisionWithTheHighestScore {

    private static List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] pref = new int[n + 1];
        pref[0] = 0;
        for (int i = 0; i < n; ++i) {
            pref[i + 1] = nums[i] + pref[i];
        }
        int maxScore = -1;
        int oneToRight;
        int zeroesToRight;
        int currScore;
        for(int i = 0; i < n + 1; i++) {
            oneToRight = pref[n] - pref[i];
            zeroesToRight = i - pref[i];
            currScore = zeroesToRight + oneToRight;
            if (currScore > maxScore) {
                res.clear();
                maxScore = currScore;
            }
            if (currScore == maxScore) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 1, 0};
        System.out.println(maxScoreIndices(nums));
    }
}
