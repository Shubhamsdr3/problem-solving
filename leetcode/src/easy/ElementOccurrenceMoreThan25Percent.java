package easy;

public class ElementOccurrenceMoreThan25Percent {

    /**
     * find integer which occurs more than 25% in the given array
     * @param arr
     * @return
     */
    private static int findSpecialInteger(int[] arr) {
        int percentage = (arr.length * 25) / 100;
        int[] count =  new int[100000];
        for (int i=0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int j =0; j < count.length; j++) {
            if (count[j] > percentage) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{1,2,2,6,6,6,6,7,10};
        System.out.println(findSpecialInteger(arr));
    }

}
