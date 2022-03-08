package implementation;

import java.util.ArrayList;
import java.util.List;

public class ArrayRotation {

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        while (k > 0) {
            int temp = a.get(a.size() -1);
            for (int i = a.size() - 1; i > 0; i--) {
                int prevItem = a.get(i - 1);
                a.set(i, prevItem);
            }
            a.set(0, temp);
            k--;
        }
        List<Integer> result = new ArrayList<>(queries.size());
        int n = a.size();
        for (Integer index: queries) {
            int i = (n - (k % n)+ index) % n;
            result.add(a.get(i));
        }
        return  result;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<Integer> queries = new ArrayList<>();
        queries.add(0);
        queries.add(1);
        queries.add(2);
        System.out.println(circularArrayRotation(input, 2, queries));
    }
}
