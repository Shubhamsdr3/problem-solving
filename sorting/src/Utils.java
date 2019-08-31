
public class Utils {
    public static void swapElement(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static float sqrt(int n) {
        double low = 0.0;
        double high = (float)n+1;
        while ((high-low) > 0.00001) {
            double mid = (low+high) / 2;
            if (mid*mid < n) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return (float) low;
    }

    public static int findMinimumOfArray(int[] arr) {
        int min = arr[0];
        for (int i=1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static boolean isNumberPalindrome(int number) {
        int temp = number;
        int sum = 0;
        while (number >0) {
            int remainder = number % 10;
            sum = sum * 10 + remainder;
            number = number /10;
        }
        return temp == sum;
    }
}
