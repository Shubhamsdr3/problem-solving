package gametheory;

import java.util.HashMap;
import java.util.Map;

public class TowerBreakers {

    private static final int P1 = 1;
    private static final int P2 = 2;

    private static int towerBreakers(int n, int m) {
        Map<Integer, Integer> towersWithHeight = new HashMap<>();
        for (int i=1; i <= n; i++) {
            towersWithHeight.put(i, m);
        }
        int tower = 0;
        int p = 1;
        for (int y = 1; y < m; y++) {
            if (m % y == 0) {
                int height = towersWithHeight.get(p);
                p = 2;
                towersWithHeight.replace(y, height - y);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int numberOfTowers = 2;
        int towerHeight = 2;
        System.out.println(towerBreakers(numberOfTowers, towerHeight));
    }
}
