package greedyalgorithm;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.Collections;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    private static int getMinimumCost(int k, Integer[] c) {
        if (k == c.length) {
            return MyUtils.sumArray(c);
        }
        Arrays.sort(c, Collections.reverseOrder());
        int numberOfItemsPurchased = 0;
        int totalMinimumCost = 0;
        for (int i=0; i< k; i++) {
            for (int j=0; j < c.length; j++) {
                totalMinimumCost = totalMinimumCost + (numberOfItemsPurchased + 1) * c[j];
                numberOfItemsPurchased ++;
            }
            numberOfItemsPurchased = 0;
        }
        return totalMinimumCost;
    }



    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 5, 6};
        System.out.println(getMinimumCost(2, array));
    }

}
