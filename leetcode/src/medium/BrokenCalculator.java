package medium;

public class BrokenCalculator {

    /**
     * MUL by 2
     * SUB by 1
     * Instead of going from startValue to target, we go from target to startvalue.
     * @param startValue
     * @param target
     * @return
     */
    private static int brokenCalc(int startValue, int target) {
        int count = 0;
        while (target > startValue) {
           count++;
           if (target % 2 == 0) {
               target = target / 2;
           } else {
               target++;
           }
        }
        count = count + (startValue - target);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(brokenCalc(5, 8));
        System.out.println(brokenCalc(1024, 1));
        System.out.println(brokenCalc(3, 10));
        System.out.println(brokenCalc(2, 3));
    }
}
