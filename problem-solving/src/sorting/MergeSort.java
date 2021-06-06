package sorting;

public class MergeSort {

    private static void merSort(int[] arr, int left, int right) {
        if (right > left) {
            int mid = (left + right) /2;
            merSort(arr, left, mid);
            merSort(arr, mid + 1, right);
            merSort(arr, left, mid);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] newArray = new int[arr.length];


    }

    public static void main(String[] args) {

    }
}
