package marchlunchtime20;

import java.util.Arrays;

public class MaximizeLcm {

    private static int findKey(int[] arr, int m) {
        int[] newArray = new int[arr.length];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        long lcm = findLCMOfArray(newArray);
        long max = Long.MIN_VALUE;
        Arrays.sort(arr);
        int result = arr[0];
        int i;
        for (i=1; i <= arr.length-1 && i <= m; i++) {
            if (result == arr[i]) {
                return result;
            }
            if (lcm + arr[i] > max) {
                result = arr[i];
                max = lcm + arr[i];
            } else if (lcm + i > max) {
                result = i;
                max = lcm + i;
            }
        }
        if (i == m) {
            return result;
        } else  {
            return result + i+1;
        }
    }

    /**
     * Using GCD
     * @param arr
     * @return
     */
    private static long findLCMOfArray(int[] arr) {
        long lcmOfArrayElements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    return 0;
                } else if (arr[i] < 0) {
                    arr[i] = arr[i] * (-1);
                }
                if (arr[i] == 1) {
                    counter++;
                }

                if (arr[i] % divisor == 0) {
                    divisible = true;
                    arr[i] = arr[i] / divisor;
                }
            }
            if (divisible) {
                lcmOfArrayElements = lcmOfArrayElements * divisor;
            }
            else {
                divisor++;
            }
            if (counter == arr.length) {
                return lcmOfArrayElements;
            }
        }
    }


    /**
     * GCD: greatest common divisor or HCF (Highest common factor)
     * using Eculid's theorem :
     * GCD(a, b) = GCD(b, a mod b) and GCD(a, 0) == a
     * @param num1
     * @param num2
     * @return
     */
    private static int findGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return findGCD(num2, num1 % num2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 6, 3};
        System.out.println(findKey(arr, 7));
//        Scanner sc =  new Scanner(System.in);
//        while (sc.hasNext()) {
//            int testCases = sc.nextInt();
//            while (testCases > 0) {
//                int n = sc.nextInt();
//                int m = sc.nextInt();
//                int[] arr = new int[n];
//                for (int i =0; i < n; i++) {
//                    arr[i] = sc.nextInt();
//                }
//                System.out.println(findKey(arr, m));
//                testCases--;
//            }
//        }
    }
}
