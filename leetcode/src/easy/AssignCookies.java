package easy;

import java.util.Arrays;

public class AssignCookies {

    private static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int j = 0; j < s.length; j++) {
            for (int i = 0; i < g.length; i++) {
                if (g[i] != -1 && s[j] >= g[i]) {
                    count++;
                    g[i] = -1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[] {3};
        System.out.println(findContentChildren(g, s));
    }
}
