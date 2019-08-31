import java.util.Arrays;

public class ShellSort {

    /**
     * The variation of insertion sort to reduce the iteration.
     * @param arr: to sort
     * @return : sorted array.
     */
    private static int[] shellSort(int[] arr) {
        for (int gap = arr.length/2; gap > 0; gap = gap/2) {
            for (int i = gap; i < arr.length; i++) {
                int newElement  = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > newElement; j = j - gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = newElement;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 35, -15, 7, 55, 1, -22};
        System.out.println(Arrays.toString(shellSort(arr)));
    }
}
