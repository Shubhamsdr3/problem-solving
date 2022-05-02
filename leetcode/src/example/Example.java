package example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Example {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(getNumPairs(list, 5, 7));
    }

    public static long getPerfectPairsCount(List<Integer> arr) {
        long count = 0;
        for (int i =0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int x = arr.get(i);
                int y = arr.get(j);
                int absX = Math.abs(x - y);
                int absY = Math.abs(x + y);
                int minFirst = Math.min(absX, absY);
                int minSecond = Math.min(Math.abs(x), Math.abs(y));
                if (minFirst <= minSecond) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long getNumPairs(List<Integer> arr, int l, int r) {
        Collections.sort(arr);
        int n = arr.size();
        int right = n - 1;
        int count = 0;

        while (right > 0) {

            // Starting index of element
            // whose sum with arr[right] >= L
            int it1 = lowerBound(arr, 0,n, l - arr.get(right)); // find the index of other element of the pair.
//            it1++;
            int start = it1 - arr.get(0);

            // Ending index of element
            // whose sum with arr[right] <= R
            int it2 = upperBound(arr, 0,n, r - arr.get(right));

            int end = it2 - arr.get(0);

            // Update the value of end
            end = Math.min(end, right - 1);

            // Add the count of elements
            // to the variable count
            if (end - start >= 0) {
                count += (end - start +1);
            }

            right--;
        }

        // Return the value of count
        return count;
    }

    static int lowerBound(List<Integer> a, int low, int high, int element){
        while(low < high){
            int middle = low + (high - low)/2;
            if(element > a.get(middle))
                low = middle + 1;
            else
                high = middle;
        }
        return low;
    }


    static int upperBound(List<Integer> a, int low, int high, int element){
        while(low < high){
            int middle = low + (high - low)/2;
            if(a.get(middle) > element)
                high = middle;
            else
                low = middle + 1;
        }
        return low;
    }
}
