package medium;

public class DeleteColumnsToMakeSorted2 {

    private static int minDeletionSize(String[] strs) {
        int res = 0, i, j;
        int n = strs.length;
        int m = strs[0].length();
        boolean[] sorted = new boolean[n -1];
        for (j = 0; j < m; j++) {
            for (i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
            if (i < n -1) continue;
            for (i = 0; i < n -1; ++i) {
                sorted[i] = strs[i].charAt(j) < strs[i + 1].charAt(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"zyx", "wvu", "tsr"};
        System.out.println(minDeletionSize(arr));
    }
}
