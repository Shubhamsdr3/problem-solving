package implementation;

public class JumpingOnTheClouds {

    private static int jumpingOnClouds(int[] c) {
        int count = 0;
        int i = 0;
        while (i < c.length-2) {
            if (c[i] == 0 && c[i+1] == 0 && c[i+2] == 0) {
                i = i + 2;
            } else if (c[i] == 0 && c[i+1] == 0 && c[i+2] == 1) {
                i++;
            } else if (c[i] == 0 && c[i+1] == 1) {
                i = i + 2;
            }
            count++;
        }
        if (i == c.length - 2 && c[c.length -1] == 0) {
            count++;
        }
        return count;
    }

    private static int jumpingOnClouds1(int[] c) {
        int count = -1;
        for (int i=0; i < c.length; i++, count++) {
            if (i < c.length -2 && c[i+2] == 0) {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 0, 0, 1, 0};
        int[] arr1 = new int[]{0, 0, 0, 1, 0, 0};
        System.out.println(jumpingOnClouds1(arr1));
    }
}
