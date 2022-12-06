package medium;

public class SplitArrayInToConsecutiveSubsequence {

    private static boolean isPossible(int[] nums) {
       if (nums == null || nums.length <= 0) {
           return false;
       }
       int curNum;
       int preNum = Integer.MIN_VALUE;
       int curEndL1, curEndL2, curEndL3;
       int preEndL1 = 0, preEndL2 = 0, preEndL3 = 0;
       int m = nums.length;
       for (int i = 0; i < m;) {
           curNum = nums[i];
           int count = 0;
           while (i < m && curNum == nums[i]) {
               i++;
               count++;
           }

           if (preNum + 1 != curNum) {
               if (preEndL1 != 0 || preEndL2 != 0) {
                   return false;
               }
               curEndL1 = count;
               curEndL2 =curEndL3 = 0;
           } else {
               if (count < preEndL1 + preEndL2) {
                   return false;
               }
               curEndL2 = preEndL1;
               curEndL3 = preEndL2;
               int res = count - preEndL1 - preEndL2;
               int numToExtendOldChain = Math.min(preEndL3, res);
               curEndL3 = curEndL3 + numToExtendOldChain;
               curEndL1 = Math.max(0, res - numToExtendOldChain);
           }
           preNum = curNum;
           preEndL1 = curEndL1;
           preEndL2 = curEndL2;
           preEndL3 = curEndL3;
       }
       return preEndL1 == 0 && preEndL2 == 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 3, 4, 4, 5, 5};
        int[] arr1 = new int[]{1,2,3,4,4,5};
        System.out.println(isPossible(arr1));
    }
}
