package implementation;

import java.util.ArrayList;
import java.util.List;

public class CutTheStick {

    //TODO: Improve the solution
    private static List<Integer> cutTheSticks(int[] arr) {
        List<Integer> result = new ArrayList<>();
        result.add(arr.length);
        int j = arr.length;
        int i =1;
        int min = findMinimum(arr);
        int[] res = subtractMinimum(min, arr);
        while (i < arr.length && j > 0) {
            if (res.length > 0) {
                result.add(i, res.length);
            }
            min = findMinimum(res);
            res = subtractMinimum(min, res);
            j--;
            i++;
        }
        return result;
    }

    private static int findMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int val: arr){
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    private static int[] subtractMinimum(int min, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int value : arr) {
            int diff = value - min;
            if (diff > 0) {
                list.add(diff);
            }
        }
        int[] result = new int[list.size()];
        for (int j=0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 4, 2, 2, 8};
        System.out.println(cutTheSticks(array));
    }
}
