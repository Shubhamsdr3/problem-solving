public class HeapSort {

    private static void heapSort(int[] arr) {

        int lastHeapIndex = arr.length -1;
        for (int i=0; i <= lastHeapIndex; i++) {
            Utils.swapElement(arr, i, lastHeapIndex -i);

        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{80, 75, 60, 68, 55, 40, 52, 67};

    }
}
