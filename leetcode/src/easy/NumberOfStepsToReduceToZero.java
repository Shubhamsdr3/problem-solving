package easy;

public class NumberOfStepsToReduceToZero {

    private static int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else  {
                num = num -1;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(13));
    }
}
