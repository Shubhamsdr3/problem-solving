package bitmanipulation;

public class TheGreatXor {

    private static long theGreatXor(long x) {
        long count = 0;
        for (int i=1; i <=x; i++) {
            if ((i ^ x) > x) {
                count++;
            }
        }
        return count;
    }

    private static long theGreatXor1(long x){
        // Complete this function
        long result = 0;
        int bitPos = 0;
        while(x > 0) {
            if((x & 1) == 0) {
                result = result +  (1L << bitPos);
            }
            bitPos++;
            x >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        long x = 10;
        System.out.println(theGreatXor1(x));
    }
}
