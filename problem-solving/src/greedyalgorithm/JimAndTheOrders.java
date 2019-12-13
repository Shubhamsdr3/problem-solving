package greedyalgorithm;

import java.util.*;

public class JimAndTheOrders  {

    // Complete the jimOrders function below.
    private static int[] jimOrders(int[][] orders) {
        System.out.println("Started time: " + System.currentTimeMillis());
        int[] result = new int[orders.length];
        if (orders.length == 1) {
            result[0] = 1;
            return result;
        }
        Map<Integer, Integer> values = new HashMap<>(orders.length);
        for (int i=0; i < orders.length; i++) {
            for (int j=0; j < orders[1].length -1; j++) {
                int sum = orders[i][j] + orders[i][j+1];
                values.put(i, sum);
            }
        }

        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<>(values.entrySet());

        // Sort the list
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        // put data from sorted list to hashmap
        Map<Integer, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        int k =0;
        for (Map.Entry<Integer, Integer> val : temp.entrySet()) {
            result[k] = val.getKey() + 1;
            k++;
        }
        System.out.println("Ended time: " + System.currentTimeMillis());
        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                    {8, 1},
                    {4, 2},
                    {5, 6},
                    {3, 1},
                    {4, 3}
        };

        int[][] ints = new int[][]{{1, 1}};

        System.out.println(Arrays.toString(jimOrders(input)));
    }
}
