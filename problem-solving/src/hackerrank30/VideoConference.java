package hackerrank30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class VideoConference {

    //TODO: FIXME
    public static List<String> solve(List<String> names) {
        HashSet<String> hashSet = new HashSet<>();
        List<String> strings = new ArrayList<>();
        int j=0;
        for (int i=0; i < names.size(); i++) {
            String string = names.get(i);
            hashSet.add(string.substring(0, j+1));
        }
        return strings;
    }

    private static int numberOfOccurrences(List<String> strings, String string) {
        int count = 1;
        for (String s: strings) {
            if (s.equals(string)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] inputArray = new String[]{"alvin", "alice", "alvin"};
        String[] inputArray1 = new String[]{"mary", "stacy", "sam", "samuel", "sam", "miguel"};
        List<String> list = new ArrayList<>(Arrays.asList(inputArray1));
        System.out.println(solve(list));
    }

}
