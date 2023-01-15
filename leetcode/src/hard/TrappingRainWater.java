package hard;

public class TrappingRainWater {

    private static int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n]; // left array
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int[] right = new int[n]; // right array
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i > 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int unit = 0;
        for (int i = 0; i < height.length; i++) {
            unit = unit + (Math.min(left[i], right[i]) - height[i]);
        }
        return unit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        };
        System.out.println(trap(arr));
    }
}
