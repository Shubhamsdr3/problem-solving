package implementation;

public class JumpingOnTheCloud {

    //TODO: Solve it ?
    private static int jumpingOnClouds(int[] clouds) {
        int count = -1;
        int n = clouds.length;
        for (int i = 0; i < n; i++) {
            count++;
            if (i < n-2 && clouds[i+2] == 0){
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] clouds = new int[]{0, 0, 1, 0, 0, 1, 0};
        int[] clouds1 = new int[]{0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(clouds1));
    }
}
