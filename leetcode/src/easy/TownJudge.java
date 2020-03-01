package easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TownJudge {

    //TODO: every one must trust on judge
    private static int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return N;
        }
        if (trust.length == 1) {
            return trust[0][1];
        }

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int[] pairAb : trust) {
            map.put(pairAb[0], pairAb[1]);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (!map.containsKey(entry.getValue())) {
                return entry.getValue();
            }
        }
        return -1;
    }

    private static int findJudge1(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] item: trust) {
            count[item[0]]--;
            count[item[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (count[i] == N-1) {
                return count[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int n= 2;
        int[][] trusts = new int[][] {
                {1, 2},
        };

        int n1 = 3;
        int[][] trusts1 = new int[][] {
                {1, 3},
                {2, 3}
        };

        int n2= 3;
        int[][] trusts2 = new int[][] {
                {1, 3},
                {2, 3},
                {3, 1}
        };

        int n3 = 4;
        int[][] trusts3 = new int[][] {
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        };

        int n4 = 4;
        int[][] trusts4 = new int[][] {
                {1, 2},
                {1, 3},
                {2, 1},
                {2, 3},
                {1, 4},
                {4, 3},
                {4, 1}
        };

        int n5 = 4;
        int[][] trusts5 = new int[][] {
                {1, 2},
                {2, 3}
        };

        int n6 = 4;
        int[][] trusts6 = new int[][] {
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        };

        System.out.println(findJudge1(n, trusts));
        System.out.println(findJudge1(n1, trusts1));
        System.out.println(findJudge1(n2, trusts2));
        System.out.println(findJudge1(n4, trusts4));
        System.out.println(findJudge1(n5, trusts5));

        System.out.println(findJudge1(n6, trusts6));

    }
}
