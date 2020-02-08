import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {

            int moneyToWithDraw = scanner.nextInt();
            float bankBalance = scanner.nextFloat();

            if (moneyToWithDraw < bankBalance && moneyToWithDraw % 5 == 0) {
                bankBalance = (float) (bankBalance - moneyToWithDraw - 0.50);
                System.out.println(bankBalance);
            } else {
                System.out.printf("%.2f", bankBalance);
            }
        }
        scanner.close();
    }


}
