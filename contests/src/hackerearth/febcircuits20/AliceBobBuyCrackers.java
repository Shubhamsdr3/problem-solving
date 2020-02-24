package hackerearth.febcircuits20;

import java.util.Scanner;

public class AliceBobBuyCrackers {

    private static void getConst(int[] costs) {
        int ways = 0;
        for (int i=0; i < costs.length; i++) {
           ways++;
        }
        System.out.println(ways);
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] cost = new int[n];
        for (int i =0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        getConst(cost);
    }
}
