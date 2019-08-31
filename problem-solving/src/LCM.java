import java.util.ArrayList;
import java.util.List;

public class LCM {


    private static int findGCD(int a, int b) {
       while (b >0) {
           int temp = b;
           b = a % b;
           a = temp;
       }
       return a;
    }

    private static int findLCM(int a, int b) {
        //LCM(a, b) = a * b / gcd(a,b)
        return a * (b / findGCD(a, b));
    }
    public static int findGCDOOfArray(int[] a) {
       int result = a[0];
       for (int i=1; i< a.length; i++) {
           result = findGCD(result, a[i]);
       }
       return result;
    }

    public static void findLCMOfArray(int[] arr) {
        int result = arr[0];
        for (int i=1; i < arr.length; i++) {
            result = findLCM(result, arr[i]);
        }
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(4);

        List<Integer> b = new ArrayList<>();
        b.add(16);
        b.add(32);
        b.add(96);

        int multiple = 0;
        for(int i : b) {
            multiple = findGCD(multiple, i);
        }
        System.err.println("Multiple: " + multiple);

        int factor = 1;
        for(int i : a) {
            factor = findLCM(factor, i);
            if (factor > multiple) {
                return;
            }
        }

        if (multiple % factor != 0) {
            return;
        }
        System.err.println("Factor: " + factor);

        int value = multiple / factor;

        int totalX = 1;

        for (int i = factor; i < multiple; i++) {
            if (multiple % i == 0 && i % factor == 0) {
                totalX++;
            }
        }
       System.out.println(totalX);
    }
}
