package Feblunchtime2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NotAllFavours {

    //TODO: FIXME:SHUBHAM
    private static int getFlavours(int[] arr, int k) {
        int i = 0;
        int j = 1;
        int max = Integer.MIN_VALUE;
        while (i < arr.length && j < arr.length) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int index = 0;
            while (index <= j) {
                map.put(index, arr[i]);
                index++;
            }
            if (isValidSegment(map, k)) {
                if (map.size() > max) {
                    max = map.size();
                }
                i++;
            }
        }
        return 0;
    }

    private static boolean isValidSegment(HashMap<Integer, Integer> map, int k) {
        int flavour = 1;
        boolean isValid = true;
        while (flavour <= k) {
            isValid = !map.containsValue(flavour);
            flavour++;
        }
        return isValid;
    }

    public static void main(String[] args) {
//        int k = 3;
//        int[] arr = new int[]{1, 1, 2, 2,1};
//        System.out.println(getFlavours(arr, k));

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int test = sc.nextInt();
            while (test > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] arr = new int[n];
                for (int i=0; i < n; i++) {
                    arr[i]= sc.nextInt();
                }
                System.out.println(getFlavours(arr, k));
                test--;
            }
        }

    }
}
