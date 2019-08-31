public class JumpingClouds {

    private static int jumpingOnClouds(int[] c, int k) {
        int energyLevel = 100;
        int n = c.length;
        for(int i=0; i< n; i = i + k) {
                if (c[i] == 0) {
                    energyLevel --;
                } else if (c[i] == 1) {
                    energyLevel = energyLevel -3;
                }
            }
        return energyLevel;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 0, 0, 1, 1, 0};
        System.out.println(jumpingOnClouds(a, 2));
    }
}
