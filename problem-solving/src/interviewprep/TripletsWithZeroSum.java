package interviewprep;

public class TripletsWithZeroSum {

    private static int findAllTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int start = i;
            int end = start + 3;
            while (start < end) {
                sum = sum + arr[start];
                start++;
            }
            if (sum == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                0, -1, 2, -3, 1
        };
        System.out.println(findAllTriplets(arr));
    }
}
