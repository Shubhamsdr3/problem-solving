package sortingproblems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class QuickSort1 {

    private static int[] quickSort(int[] arr) {
        int pivot = arr[0];
        int[] result = new int[arr.length];
        int j = 0;
        // for the elements less than pivot.
        for (int i=0; i< arr.length; i++) {
            if (arr[i] < pivot) {
                result[j] = arr[i];
                j++;
            }
        }
        // for the pivot element.
        result[j] = arr[0];
        j++;
        // For the elements greater than pivot.
        for (int i=0; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }

    private static int[] quickSort2(int[] arr) {
        int[] result = new int[arr.length];
        LinkedList<Integer> al = new LinkedList<Integer>();
        al.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[0])
                al.addLast(arr[i]);
            else al.addFirst(arr[i]);
        }

        Iterator itr = al.iterator();
        int i = 0;
        while (itr.hasNext() && i < al.size()) {
            result[i] = al.get(i);
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] inputArray = new int[]{4, 4, 5, 3, 7, 2};
        System.out.println(Arrays.toString(quickSort(inputArray)));
//        System.out.println(Arrays.toString(quickSort2(inputArray)));
    }
}
