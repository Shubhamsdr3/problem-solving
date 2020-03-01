package easychallenge;

import java.util.*;

public class DextersLab {

    private static int minimumVapour(int[] arr) {
        Arrays.sort(arr);
        Stack<Integer> list = new Stack<>();
        list.add(arr[0]);
        int i=1;
        int vap = 0;
        while (i < arr.length) {
            vap = vap + list.peek() * arr[i];
            int dens = (list.peek() + arr[i]) % 100;
            list.add(dens);
            i++;
        }
        return vap;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{40, 50, 60, 70};
//        int[] arr1 = new int[]{10, 20, 30};
//        int[] arr2 = new int[]{15, 14};
//        System.out.println(minimumVapour(arr));
//        System.out.println(minimumVapour(arr1));
//        System.out.println(minimumVapour(arr2));
        Scanner sc  = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i =0; i <n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(minimumVapour(arr));
            test--;
        }
    }
}
