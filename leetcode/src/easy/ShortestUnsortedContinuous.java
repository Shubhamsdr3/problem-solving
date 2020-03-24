package easy;

public class ShortestUnsortedContinuous {

    //FIXME: SHUBHAM
    private static int findUnsortedSubArray(int[] nums) {
        int i =0;
        int j = i+1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] > nums[j]) {

            }
        }
        return 0;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubArray(arr));
    }
}


