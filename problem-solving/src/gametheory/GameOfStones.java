package gametheory;

public class GameOfStones {

    private static final String P1 = "First";
    private static final String P2 = "Second";

    private static String gameOfStones(int n) {
        if(n % 7 == 0 || n % 7 == 1) {
            return P2;
        } else {
            return P1;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(gameOfStones(1));
        System.out.println(gameOfStones(2));
        System.out.println(gameOfStones(3));
        System.out.println(gameOfStones(4));
        System.out.println(gameOfStones(5));
        System.out.println(gameOfStones(6));
        System.out.println(gameOfStones(8));
        System.out.println(gameOfStones(9));
        System.out.println(gameOfStones(10));
        System.out.println(gameOfStones(11));
    }
}
