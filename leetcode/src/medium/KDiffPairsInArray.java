package medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
Created at: 08/02/22
*/

public class KDiffPairsInArray {

    static class Pair {

        private Integer first;
        private Integer second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second) ||
                    Objects.equals(second, pair.first) && Objects.equals(pair.second, first);
        }

        @Override
        public int hashCode() {
            return first.hashCode() ^ second.hashCode();
        }
    }

    private static int findPairs(int[] nums, int k) {
        Set<Pair> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                if (diff == k) {
                    set.add(new Pair(nums[i], nums[j]));
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,4,4,3,3,0,9,2,3};
        int k = 3;
        System.out.println(findPairs(input, k));
    }
}
