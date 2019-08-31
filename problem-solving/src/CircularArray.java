import java.util.Arrays;

public class CircularArray {
    private static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        for (int i=0; i < k; i++) {
            int last = a[a.length -1];
            for (int j= a.length-1; j > 0; j--) {
                a[j] = a[j -1];
            }
            a[0] = last;
        }
        System.out.println(Arrays.toString(a));
        int[] result = new int[a.length];
        for (int m=0; m< queries.length; m++) {
            result[m] = a[queries[m]];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = new int[] {1122112, 221242, 33432143, 35423534, 34534543, 645647567, 586786798, 34534534, 1232223, 234234,254354,567567,86876786,346};
        int[] q =  new int[] {0,1,2,3};
        int k = 1;
        System.out.println(Arrays.toString(circularArrayRotation(a, k, q)));
    }
}
