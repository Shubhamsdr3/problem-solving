public class SquareIntegers {

    /**
     * To get the perfect squares integer in the give range.(a,b)
     * @param a : Exclusive
     * @param b: inclusive
     * @return : number of integers
     */
    private static int squares(int a, int b) {
        int count = 0;
        for(int i = a; i <= b; i++) {

            for (int j=1; j * j <= i; j++ ) {
                if (j * j ==i) {
                    count ++;
                }
            }
        }
        return count;
    }

    private static int squares2(int a, int b) {
      return (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a))) + 1;
    }

    public static void main(String[] args) {
//        System.out.println(squares(17, 24));
        System.out.println(squares2(3, 9));
    }
}
