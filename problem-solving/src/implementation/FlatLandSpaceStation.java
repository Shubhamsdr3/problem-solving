package implementation;


import java.util.Arrays;

public class FlatLandSpaceStation {

    //TODO:SHUBHAM
    private static int flatlandSpaceStations(int n, int[] c) {
        if (n == c.length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Arrays.sort(c);
       for (int i = 0; i < c.length; i++) {
           if (i == c.length -1) {
               return n - (c[c.length -1] +1);
           }
           int diff = Math.abs(c[i+1] - (c[i]+1));
           if (diff > max) {
               max = diff;
           }
       }
       return max;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] citiesWithSS = new int[]{0, 4};
        int[] citiesWithSS1 = new int[]{13, 1, 11, 10, 6};
        System.out.println(flatlandSpaceStations(n, citiesWithSS));
    }
}
