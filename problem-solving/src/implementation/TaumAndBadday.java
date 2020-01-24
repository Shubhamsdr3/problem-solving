package implementation;

public class TaumAndBadday {

    /**
     * b: the number of black gifts
     * w: the number of white gifts
     * bc: the cost of a black gift
     * wc: the cost of a white gift
     * z: the cost to convert one color gift to the other color
     * @return :
     */
    private static long taumBday(int b, int w, int bc, int wc, int z) {
        // case #1.
        long result;
        if (bc > wc && bc > z) {
            result =  w * wc + b * (wc + z);
            return result;
        } else if (wc > bc && wc > z) {
            // case #2
            result =  b * bc + w * (bc + z);
            return result;
        } else if ((z > wc && z > bc) || wc == bc) {
            // case #3.
            result =  b * bc + w * wc;
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {

        //Case 1:
        int b = 10;
        int w = 10;
        int bc = 1;
        int wc = 1;
        int z = 1;

        //Case 2:
        int b1 = 5;
        int w1 = 9;
        int bc1 = 2;
        int wc1 = 3;
        int z1 = 4;

        //Case 3:
        int b2 = 3;
        int w2 = 6;
        int bc2 = 9;
        int wc2 = 1;
        int z2 = 1;

        //Case 4:
        int b3 = 7;
        int w3 = 7;
        int bc3 = 4;
        int wc3 = 2;
        int z3 = 1;

        //Case 5:
        int b4 = 3;
        int w4 = 3;
        int bc4 = 1;
        int wc4 = 9;
        int z4 = 2;
        System.out.println(taumBday(b, w, bc, wc, z));
        System.out.println(taumBday(b1, w1, bc1, wc1, z1));
        System.out.println(taumBday(b2, w2, bc2, wc2, z2));
        System.out.println(taumBday(b3, w3, bc3, wc3, z3));
        System.out.println(taumBday(b4, w4, bc4, wc4, z4));
    }
}
