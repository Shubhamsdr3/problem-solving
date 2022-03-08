package medium;

public class FindTheDuplicateNumber {

    private static int findDuplicate(int[] nums) {
        int[] count = new int[nums.length +1];
        for (int num: nums) {
            count[num]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,1,5,2, 6};
        System.out.println(findDuplicate(arr));
    }
}
