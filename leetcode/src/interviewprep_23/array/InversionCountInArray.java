package interviewprep_23.array;

import java.util.*;

public class InversionCountInArray {

    /**
     * Using Heapsort and bisection.
     * @param numbers
     * @return
     */
    private static int inversionCountUsingHeapSort(List<Integer> numbers) {
        int n = numbers.size();
        if (n <= 1) return 0;

        PriorityQueue<int[]> sortList = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int result = 0;
        // heapsort
        for (int i = 0; i < n; i++) {
            sortList.add(new int[] { numbers.get(i), i });
        }
        List<Integer> x = new ArrayList<>();
        while (!sortList.isEmpty()) { // O(log(N)
            int[] v = sortList.poll();
            int y = x.size() - x.subList(0, x.size()).indexOf(v[1]) - 1;
            int z = 0;
            if (!x.isEmpty()) {
                z = binarySearch(x, 0, x.size() - 1, v[1]);
                if (z < 0) z = - (z + 1);
            }

            // i can represent how many elements on the left.
            // i - y can find how many bigger nums on the left.
            result = result + v[1] - z;
            x.add(v[1]);
            x.sort(null);
        }
        return result;
    }

    private static int binarySearch(List<Integer> list, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == key) {
                return mid;
            } else if (list.get(mid) > key) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return -(start + 1);
    }

    /**
     * Using merge sort
     * @param arr
     * @param l
     * @param m
     * @param r
     * @return
     */
    private static int inversionCountUsingMergeSort(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1); // left sub-array
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); // right sub-array

        int i = 0;
        int j = 0;
        int k = l;
        int swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps = swaps + (m + 1) - (l + i);
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return swaps;
    }

    /**
     * Total inversion count:
     * left subarray count + right subarray count + merge count
     * T.C -> O(N * log N)
     * Space -> O(N)
     */
    private static int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count = count + mergeSortAndCount(arr, l, m); // left subarray
            count = count + mergeSortAndCount(arr, l, m); // right subarray
            count = count + inversionCountUsingMergeSort(arr, l, m, r);
        }
        return count;
    }

    /**
     * Naive approch.
     * T.C -> O(n^2)
     * @param arr
     * @return
     */
    private static int inversionCount(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 8, 4, 2, 1 };
        int[] arr1 = new int[]{ 1, 20, 6, 4,5 };
        System.out.println(mergeSortAndCount(arr1, 0, arr1.length -1));
    }
}

