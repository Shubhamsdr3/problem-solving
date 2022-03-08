package medium;

public class NumArray {

    private final int[] arr;

    public NumArray(int[] nums) {
        this.arr = nums;
    }

    public void update(int index, int val) {
        if (index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException("Index is: " + index);
        }
        arr[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 5};
        NumArray array = new NumArray(input);
        System.out.println(array.sumRange(0, 2));
        array.update(1, 2);
        System.out.println(array.sumRange(0, 2));
    }
}
