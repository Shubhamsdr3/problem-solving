package sortingproblems;

import java.util.Scanner;

public class TuitorialIntro {

    private static int introTutorial(int V, int[] arr) {
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == V) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 5, 7, 9};
        int num = 4;
        System.out.println(introTutorial(num, array));
    }
}
