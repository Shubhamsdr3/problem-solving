package bitmanipulation;

public class LonelyInteger {

    private static int lonelyinteger(int[] a) {
        if (a.length < 2) {
            return a[0];
        }
        int[] counter = new int[101];
        for (int i=0; i < a.length; i++) {
            counter[a[i]]++;
        }

        for (int j=0; j < counter.length; j++) {
            if (counter[j] == 1) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 2, 1};
        int[] arr1 = new int[]{1, 1, 2};
        System.out.println(lonelyinteger(arr1));
    }

}
