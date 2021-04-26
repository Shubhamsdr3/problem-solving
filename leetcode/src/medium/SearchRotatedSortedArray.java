package medium;

public class SearchRotatedSortedArray {

    private static boolean search(int[] nums, int target) {
       int start = 0;
       int end = nums.length -1;
       int mid = -1;
       while (start <= end) {
           mid = start + (end -start) / 2;
           if (nums[mid] == target) {
               return true;
           }
       }
    }

    public static void main(String[] args) {
        int[] input = new int[] {
                2,5,6,0,0,1,2
        };
        int target = 3;
        System.out.println(search(input, target));
    }
}
