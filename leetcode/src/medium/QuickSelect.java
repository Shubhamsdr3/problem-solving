package medium;

public class QuickSelect {

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivotLoc = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotLoc];
                arr[pivotLoc] = temp;
                pivotLoc++;
            }
        }
        int temp = arr[high];
        arr[high] = arr[pivotLoc];
        arr[pivotLoc] = temp;
        return pivotLoc;
    }

    private static int kthSmallest(int[] arr, int low, int high, int k) {
        int partition = partition(arr, low, high);
        if (partition == k -1) {
            return arr[partition];
        } else if (partition < k -1) {
            return kthSmallest(arr, partition + 1, high, k);
        } else {
            return kthSmallest(arr, low, partition -1, k);
        }
    }

    public static void main(String[] args) {

    }
}
