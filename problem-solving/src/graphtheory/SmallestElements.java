package graphtheory;
public class SmallestElements {

    private static int getSmallestSubarray(int[] arr, int x) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            int size = 1;
            for(int j = i+1; j < arr.length; j++) {
                sum = sum + arr[j];
                size++;
                if(sum > x) {
                    min = Math.min(size, min);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                1, 2, 4
        };
        int x = 8;
        System.out.println(getSmallestSubarray(arr, x));
    }
}
