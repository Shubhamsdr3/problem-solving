import java.util.Arrays;

public class MergeSort {

   private static int[] mergeSort(int[] arr, int start, int end) {
       if (end - start < 2) {
           return null;
       }
       //1. Splitting array.
       int mid = (start + end)/ 2;
       //for the left sub-array
       mergeSort(arr, start, mid);
       //for the right sub-array
       mergeSort(arr, mid, end);

       //2. Merging array.
       merge(arr, start, mid, end);
       return arr;
   }

   private static void merge(int[] arr, int start, int mid, int end) {
       if (arr[mid -1] <= arr[mid]) {
           return;
       }
       int i = start;
       int j = mid;
       int tempIndex = 0;

       int[] tempArr = new int[end - start];
       while (i < mid && j < end) {
           tempArr[tempIndex ++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
       }
       // If someone could please explain this ??
       System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
       System.arraycopy(tempArr, 0, arr, start, tempIndex);
   }

   public static void main(String[] args) {
       int[] inputArray = new int[]{20, 35, -15, 7, 55, 1, -22};
       System.out.println(Arrays.toString(mergeSort(inputArray, 0, inputArray.length)));
   }
}
