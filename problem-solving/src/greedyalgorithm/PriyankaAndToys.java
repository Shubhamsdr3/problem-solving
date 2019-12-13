package greedyalgorithm;

import java.util.Arrays;

public class PriyankaAndToys {

    // Complete the toys function below.
    private static int toys(int[] weights) {
        Arrays.sort(weights);
        int numberOfContainer = 1;
        for (int i=0; i < weights.length;) {
            int range = weights[i] + 4;
            int j;
            for (j=i + 1; j< weights.length; j++) {
                if (weights[j] > range) {
                    numberOfContainer ++;
                    break;
                }
            }
            i = j;
        }
        return numberOfContainer;
    }

    // Better one
    private static void toys1(int[] a) {
        Arrays.sort(a);
        int cost=1;
        int p=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]>p+4){
                cost=cost+1;
                p=a[i];
            }
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 21, 7, 12, 14, 21};
        int toys = toys(weights);
        System.out.println(toys);
    }

}
