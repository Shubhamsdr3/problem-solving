package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AbsolutePermutation {

    private static int[] absolutePermutation(int n, int k) {
       int[] result = new int[n];
        for (int i=0; i < n; i++) {
            result[i] = i+1;
        }
        int position = 1;
        while (n > 0) {
            for (int j=0; j < result.length; j++) {
                if (result[j] - position != k) {
                    break;
                }
                position++;
            }
            if (position == n +1) {
                return result;
            }
            n--;
            result = permute(result, k);
        }

        return new int[]{1, 2};
    }

    private static int[] permute(int[] arr, int k){
        List<Integer> list = new ArrayList<>();
        for (int val: arr) {
            list.add(val);
        }
        for(int i = k; i < list.size(); i++){
            Collections.swap(list, i, k);
            permute(arr, k+1);
            Collections.swap(list, k, i);
        }
        int[] res = new int[list.size()];
        for (int i=0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        if (k == list.size()-1) {
            return res;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 0;
        int n1 = 2;
        int k1 = 1;
        System.out.println(Arrays.toString(absolutePermutation(n1, k1)));
    }

}
