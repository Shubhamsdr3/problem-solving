package medium;

public class StringWithoutAAA {

    private static String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder(A + B);
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (B > A) {
            a = 'b';
            b = 'a';
            i = B;
            j = A;
        }
        while (i-- > 0) {
            res.append(a);
            if (i > j) {
                res.append(a);
                --i;
            }
            if (j-- > 0) {
                res.append(b);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        System.out.println(strWithout3a3b(a, b));
    }
}
