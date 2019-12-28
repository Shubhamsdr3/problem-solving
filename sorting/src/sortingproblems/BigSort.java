package sortingproblems;

import java.util.Arrays;

public class BigSort {

    private static String[] bigSorting(String[] unsorted) {

        Arrays.sort(unsorted, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i=0; i < o1.length(); i++) {
                    char left = o1.charAt(i);
                    char right = o2.charAt(i);
                    if (left != right)
                        return left - right;
                }
            }
            return o1.length() - o2.length();
        });

        return unsorted;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{
                "6",
                "31415926535897932384626433832795",
                "1",
                "3",
                "10",
                "3",
                "5"
        };

        String[] strings1 = new String[]{
                "1",
                "2",
                "100",
                "12303479849857341718340192371",
                "3084193741082937",
                "3084193741082938",
                "111",
                "200"
        };
        System.out.println(Arrays.toString(bigSorting(strings1)));
    }

}
