package implementation;

public class HalloweenSale {

    private static int howManyGames(int p, int d, int m, int s) {
        int numberOfGames = 0;
        if (s < p) {
            return 0;
        }
        if (p == 1) {
            return s;
        }
        while (s >= p ) {
            s = s - p;
            p = Math.max(p-d, m); // #The Catch.....
            numberOfGames++;
        }
        return numberOfGames;
    }

    public static void main(String[] args) {
        int price = 100;
        int discount = 3;
        int minimumPrice = 100;
        int walletBalance = 6234;
        int price1 = 100;
        int discount1 = 19;
        int minimumPrice1 = 1;
        int walletBalance1 = 180;

        int price2 = 88;
        int discount2 = 77;
        int minimumPrice2 = 88;
        int walletBalance2 = 9912;

        int price3 = 16;
        int discount3 = 2;
        int minimumPrice3 = 1;
        int walletBalance3 = 9981;

        System.out.println(howManyGames(price3, discount3, minimumPrice3, walletBalance3));
    }

}
