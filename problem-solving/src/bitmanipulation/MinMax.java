package bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMax {

    private static int anotherMinimaxProblem(int[] a) {
        int max = Integer.MIN_VALUE;
        int k = a.length -1;
        List<Integer> list = new ArrayList<>();
        for (int val: a) {
            list.add(val);
        }
        while (k > 0) {
            int[] permute = permute(list);
            for (int i=0; i < permute.length-1; i++) {
                int val = permute[i] ^ permute[i+1];
                if (val > max) {
                    max = val;
                }
            }
            k--;
        }
        return max;
    }

    private static int[] permute(List<Integer> list){
        for(int i = 0; i < list.size() -1; i++){
            Collections.swap(list, i, i+1);
        }
        int[] res = new int[list.size()];
        for (int i=0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.print(anotherMinimaxProblem(arr));
    }
}
