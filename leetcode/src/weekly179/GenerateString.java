package weekly179;

public class GenerateString {

    private static String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
           for (int i =0; i < n; i++) {
               if (i % 2 != 0) {
                   sb.append('a');
               }
           }
           for (int i = 0; i < n; i++) {
               if (i % 2 != 0) {
                   sb.append('a');
               }
           }
           n--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.print(generateTheString(n));
    }
}
