package easy;

import java.util.HashSet;
import java.util.Set;

public class DistinctString {

    private static String kthDistinct(String[] arr, int k) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String str: arr) {
            if (set.add(str)) {
                count++;
            } else  {
                count--;
            }
        }
        return "";
    }

    public static void main(String[] args) {

    }
}
