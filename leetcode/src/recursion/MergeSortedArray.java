package recursion;

public class MergeSortedArray {

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m -1;
        int i2 = n -1;
        int j = m + n -1;
        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[j--] = nums1[i1--];
            } else {
                nums1[j--] = nums2[i2--];
            }
        }
        while (i2 > 0) {
            nums1[j--] = nums2[i2--];
        }
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n -1);
        }
    }

    private static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number is negative: " + n);
        } else if (n == 1 || n == 2) {
            return n -1;
        } else {
            return fibonacci(n -1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] input2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        merge(input1, m, input2, n);
    }
}
