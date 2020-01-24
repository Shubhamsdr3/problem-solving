package implementation;

import java.util.Arrays;

public class AcmIcpcTeam {

    //TODO: find number of teams ??
    private static int[] acmTeam(String[] topic) {
       int max = Integer.MIN_VALUE;
        int k = 0;
        int n = 0;
        int teamCount = 0;
        while (n < topic.length -1) {
            for (int i=0; i < topic[n].length(); i++) {
                int count = 0;
                for (int j=0; j < topic[n+1].length(); j++) {
                    if (topic[n].charAt(k) == '1' || topic[n+1].charAt(k) == '1') {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    teamCount = 1;
                } else if (count == max) {
                    teamCount++;
                }
            }
            n++;
        }
        int[] result = new int[2];

        result[0] = max;
        result[1] = teamCount;
        return result;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"10101", "11100", "11010", "00101"};
        String[] arr1 = new String[]{"10101", "11110", "00010"};
        System.out.println(Arrays.toString(acmTeam(arr)));
    }
}
