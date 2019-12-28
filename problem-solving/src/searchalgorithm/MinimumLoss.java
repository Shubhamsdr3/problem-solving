package searchalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumLoss {

    // Complete the minimumLoss function below.
    private static int minimumLoss(long[] price) {

        List<Long> list = new ArrayList<>();
        List<Long> sortedList = new ArrayList<>();
        for (long val: price) {
            sortedList.add(val);
            list.add(val);
        }
        Collections.sort(sortedList);

        int minimum = Integer.MAX_VALUE;
        for (int i=1; i <= price.length -1; i++) {
            long diff = sortedList.get(i) - sortedList.get(i -1);
            if (diff < minimum && (list.indexOf(list.get(i)) < list.indexOf(list.get(i -1)))) {
                minimum = (int) diff;
            }
        }

        return minimum;
    }

    public static void main(String[] args) {

        long[] inputs = new long[]{20, 7, 8, 2, 5};
        long[] inputs1 = new long[]{5, 10, 3};
        System.out.println(minimumLoss(inputs1));
    }
}
