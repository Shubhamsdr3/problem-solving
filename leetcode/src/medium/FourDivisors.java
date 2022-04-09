package medium;

public class FourDivisors {

    /**
     * TLE
     * @param nums
     * @return
     */
    private static int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int divisor = 1;
            int count = 0;
            int sum = 0;
            while (divisor <= num) {
                if (num % divisor == 0) {
                    count++;
                    sum = sum + divisor;
                }
                if (num % 2 == 0) {
                    divisor++;
                } else {
                    divisor = divisor + 2;
                }
            }
            if (count == 4) {
                res = res + sum;
            }
        }
        return res;
    }


    private static int sumFourDivisorsOptimized(int[] nums) {
        int res = 0;
        for (int num: nums) {
            int lastDigit = 0;
            for (int d = 2; d * d <= num; ++d) {
                if (num % d == 0) {
                    if (lastDigit == 0) {
                        lastDigit = d;
                    } else {
                        lastDigit = 0;
                        break;
                    }
                }
            }
            if (lastDigit > 0 && lastDigit != num / lastDigit) {
                res = res + 1 + num + lastDigit + num / lastDigit;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{8, 21, 31, 89};
        System.out.println(sumFourDivisorsOptimized(arr));
    }
}
