package marchchallenge2020;

import java.util.*;

public class PintuAndFruits {

    private static int minimumCost(int n, int m , int[] fruits, int[] baskets) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i =0;
        int j =0;
        while (i < fruits.length && j < baskets.length) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + baskets[j]);
            i++;
            j++;
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        int n = 6;
//        int m = 4;
//        int[] fruits = new int[]{1, 2, 3, 3, 2, 2};
//        int[] baskets = new int[]{7, 3, 9, 1, 1, 1};
//        System.out.print(minimumCost(fruits, baskets));

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int test = sc.nextInt();
            while (test > 0) {
//            String[] str = sc.nextLine().split(" ");
//            int n = Integer.parseInt(str[0]);
//            int m = Integer.parseInt(str[1]);
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[] fruits = new int[n];
                int[] baskets = new int[n];
                for (int i = 0; i < n; i++) {
                    fruits[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    baskets[i] = sc.nextInt();
                }
                System.out.print(minimumCost(n, m, fruits, baskets));
                test--;
            }
        }

    }

}
