package biweekly20;


import java.util.*;

public class SortByBits {

    private static int[] sortByBits(int[] arr) {
        if (isAllNumbersHaveSameBits(arr)) {
            Arrays.sort(arr);
            return arr;
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0; i <arr.length; i++) {
            list.add(arr[i]);
        }
        list.sort(Comparator.comparingInt(SortByBits::countNumberOf1s));

        int[] arr1 = new int[list.size()];
        for (int j=0; j < arr1.length; j++){
            arr1[j] = list.get(j);
        }
        return arr1;
    }

    private static boolean isAllNumbersHaveSameBits(int[] arr) {
        for (int i=0; i < arr.length -1; i++) {
            if (countNumberOf1s(arr[i]) != countNumberOf1s(arr[i+1])) {
                return false;
            }
        }
        return true;
    }

    private static int countNumberOf1s(int number) {
        String binary = Integer.toBinaryString(number);
        int count = 0;
        for (char c: binary.toCharArray()) {
            if (Character.getNumericValue(c) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,100,1000,10000};
        int[] arr1 = new int[]{0,1,2,4,8,3,5,6,7};
        int[] arr2 = new int[]{1111,7644,1107,6978,8742,1,7403,7694,9193,4401,377,8641,5311,624,3554,6631};
        System.out.println(Arrays.toString(sortByBits(arr2)));
    }
}
