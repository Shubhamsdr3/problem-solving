package bitmanipulation;

public class ANDProduct {

    private static long andProduct(long a, long b) {
        long val = a;
        for (long i=a; i <=b; i++) {
            val = val & val+1;
        }
        return val;
    }

    public static void main(String[] args) {
        long a = 12;
        long b = 15;
        long a1 = 2;
        long b1 = 3;
        long a2 = 8;
        long b2 = 13;

        long a3 = 17;
        long b3 = 23;

        long a4 = 11;
        long b4 = 15;
        System.out.println(andProduct(a, b));
        System.out.println(andProduct(a1, b1));
        System.out.println(andProduct(a2, b2));
        System.out.println(andProduct(a3, b3));
        System.out.println(andProduct(a4, b4));
    }
}
