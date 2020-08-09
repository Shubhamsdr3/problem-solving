import java.util.Scanner;

public class LifeUniverseEverything {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if(num == 42) {
                System.exit(0);
            } else {
                System.out.println(num);
            }
        }
    }
}
