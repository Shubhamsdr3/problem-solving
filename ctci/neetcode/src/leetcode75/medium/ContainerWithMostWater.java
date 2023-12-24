package leetcode75.medium;

public class ContainerWithMostWater {


    /**
     * T.C -> O(n)
     * @param height
     * @return
     */
    private static int maxArea2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (i < j) {
            int min = Math.min(height[i], height[j]);
            int area = min * (j - i);
            maxArea = Math.max(area, maxArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    /**
     * T.C -> O(n^2)
     * @param height
     * @return
     */
    private static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                int area = min * (j - i);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1,8,6,2,5,4,8,3,7 };
        System.out.println(maxArea2(arr));
    }
}
