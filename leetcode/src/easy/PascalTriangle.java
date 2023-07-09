package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    private static List<List<Integer>> generate(int numberOfRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 1; i <= numberOfRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(new ArrayList<>(row));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
