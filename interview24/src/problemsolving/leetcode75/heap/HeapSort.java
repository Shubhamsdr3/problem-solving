package problemsolving.leetcode75.heap;

public class HeapSort {


    private static int[] arr = new int[10];

    /**
     * T.C ->
     */
    public static void heapSort() {
        heapify(arr.length - 1);
        int endIndex = arr.length - 1;
        while (endIndex > 0) {
            swap(0, endIndex);
            endIndex--;
            percolateDown(0, endIndex);
        }
    }

    public static void heapify(int endIndex) {
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0) {
            percolateDown(index, endIndex);
            index--;
        }
    }

    private  static void percolateDown(int index, int endIndex) {
        int leftChildIndex = getLeftChildIndex(index, endIndex);
        int rightChildIndex = getRightChildIndex(index, endIndex);
        if (leftChildIndex != -1 && arr[leftChildIndex] > arr[index]) {
            swap(leftChildIndex, index);
            percolateDown(leftChildIndex, endIndex);
        }
        if (rightChildIndex != -1 && arr[rightChildIndex] > arr[index]) {
            swap(rightChildIndex, index);
            percolateDown(rightChildIndex, endIndex);
        }
    }

    public static int getLeftChildIndex(int index, int endIndex) {
        int leftChildIndex = 2 * index + 1; // left child.
        if (leftChildIndex >= endIndex) {
            return -1; // no left child.
        }
        return leftChildIndex;
    }

    public static int getRightChildIndex(int index, int endIndex) {
        int rightChildIndex = 2 * index + 2; // right child.
        if (rightChildIndex >= endIndex) {
            return -1; // no left child.
        }
        return rightChildIndex;
    }

    public static int getParentIndex(int index, int endIndex) {
        if(index < 0 || index > endIndex) {
            return -1;
        }
        return (index - 1)/ 2; // parent.
    }

    private static void swap(int index1, int index2) {
        int tempVal = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempVal;
    }

    public static void main(String[] args) {

    }
}
