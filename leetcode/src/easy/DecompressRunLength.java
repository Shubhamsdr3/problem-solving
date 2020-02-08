package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRunLength {

    private static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        int j = i+1;
        while (i < nums.length && j < nums.length) {
            int frequency = nums[i];
            int val = nums[j];
            while (frequency > 0) {
                list.add(val);
                frequency--;
            }
            i = j+1;
            j = i+1;
        }

        int[] res = new int[list.size()];
        for (int k=0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{100,100, 89, 90};
        System.out.print(Arrays.toString(decompressRLElist(input)));
    }
}
