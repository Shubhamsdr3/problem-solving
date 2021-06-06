package medium;

import java.util.Map;

public class MaxWater {

    private static int maxArea(int[] height) {
        int i = 0;
        int j = i+1;
        int maxArea = Integer.MIN_VALUE;
        while (i < height.length && j < height.length) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (j == height.length -1) {
                i++;
                j = i+1;
            } else  {
                j++;
            }
        }
        return maxArea;
    }

    private static int maxArea1(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else  {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[] {
                2, 3, 4, 5, 18, 17, 6
        };
        System.out.println(maxArea1(height)); //17 -> 16
    }
}
