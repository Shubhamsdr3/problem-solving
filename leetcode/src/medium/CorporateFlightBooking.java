package medium;

import java.util.Arrays;

public class CorporateFlightBooking {

    private static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] row = bookings[i];
            for (int j = row[0]; j <= row[1]; j++) {
                arr[j - 1] = arr[j - 1] + row[2];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 2, 10},
                {2, 2, 15},
        };
        int n = 2;
        System.out.println(Arrays.toString(corpFlightBookings(arr, n)));
    }
}
