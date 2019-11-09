import java.util.*;


public class BucketSort {

    /**
     * We are using Collections.sort() method to sort the list of buckets.
     * We can also use Insertion sort as well which take O(n) time.
     * @param arr : to be sorted
     * @return : sorted array.
     */
    private static int[] bucketSort(int[] arr) {
        List<Integer>[] buckets = new List[10];
        // Create an buckets with list.
        for (int i=0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();

            // We can also use LinkedList as well.
//            buckets[i] = new LinkedList<>();
        }
        // Scattering phase: store the value from the array at their hashed position in buckets.
        for (int j = 0; j < arr.length; j++) {
            buckets[hashValue(arr[j])].add(arr[j]);
        }
        // Sort the bucket list.
        for (List<Integer> list : buckets) {
            Collections.sort(list);
        }
        // Gathering phase: merge the sorted list of each bucket to an sorted array.
        int j = 0;
        for (int k=0; k < buckets.length; k++) {
            for (int value: buckets[k]) {
                arr[j++] = value;
            }
        }
        return arr;
    }

    private  static int hashValue(int value) {
        // It just gives the element at 10th position of value.
        return value / 10;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{54, 46, 83, 66, 95, 92, 43};
        System.out.print(Arrays.toString(bucketSort(arr)));
    }
}
