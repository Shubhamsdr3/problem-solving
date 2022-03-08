package medium;

class Power {

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        double sum = 1;
        boolean isNegative = x < 0;
        x = Math.abs(x);
        if (n > 0) { // if n is positive
            while (n  > 0 ) {
                sum = sum * x;
                n--;
            }
        } else  {  // if n is negative
            int k = Math.abs(n);
            double localSum = 1;
            while (k > 0) {
                localSum = localSum * x;
                k--;
            }
            sum = 1/ localSum;
        }
        if(isNegative) {
            return -sum ;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0000, -2147483648));
    }
}