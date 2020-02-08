package implementation;

public class TheChocolateFest {

    private static int chocolateFeast(int n, int c, int m) {
        int numberOfChocolates = n / c;
        int wrappers = numberOfChocolates;
        while (wrappers >= m) {
            wrappers = wrappers / m;
            numberOfChocolates ++;
            wrappers ++;
        }
        return numberOfChocolates;
    }

    public static void main(String[] args) {
        int moneyToSpend = 10;
        int costOfChocolate = 2;
        int numberOfWrappers = 5;

        int moneyToSpend1 = 12;
        int costOfChocolate1 = 4;
        int numberOfWrappers1 = 4;

        int moneyToSpend2 = 20373;
        int costOfChocolate2 = 18211;
        int numberOfWrappers2 = 10188;
        System.out.println(chocolateFeast(moneyToSpend, costOfChocolate, numberOfWrappers));
        System.out.println(chocolateFeast(moneyToSpend1, costOfChocolate1, numberOfWrappers1));
        System.out.println(chocolateFeast(moneyToSpend2, costOfChocolate2, numberOfWrappers2));
    }
}
