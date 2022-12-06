package example;

import java.util.ArrayList;
import java.util.List;

public class BalancedArray {

    public static int balancedSum(List<Integer> arr) {
        int low = 0;
        int high = arr.size();
        int mid = low + (high - low) / 2;
        while (mid >= 0 || mid < arr.size()) {
            int leftSum = findLeftSum(arr, mid);
            int rightSum = findRightSum(arr, mid + 1);
            if (leftSum == rightSum) {
                return mid;
            } else if (rightSum > leftSum) {
                mid = mid + 1;
            } else {
                mid = mid - 1;
            }
        }
        return mid;
    }


    private  static int solve(int[] a){
        int s1=0,s2=0,n=a.length/2;
        for(int i=0;i<n;++i)
            s1+=a[i];
        for(int i=2*n-1;i>=n;--i)
            s2+=a[i];
        return Math.max((s2-s1),(s1-s2));
    }

    private static int pivotIndex(int[] nums) {
        int total = 0, sum = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length; sum += nums[i++])
            if (sum * 2 == total - nums[i]) return i;
        return -1;
    }

    private static int findLeftSum(List<Integer> arr, int index) {
        int sum = 0;
        while (index >= 0) {
            sum = sum + arr.get(index--);
        }
        return sum;
    }

    private static int findRightSum(List<Integer> arr, int index) {
        int sum = 0;
        while (index < arr.size()) {
            sum = sum + arr.get(index++);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        int[] arr = new int[] {
                1, 2, 3, 4, 5, 6
        };
        System.out.println(pivotIndex(arr));
    }
}
