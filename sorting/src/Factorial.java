public class Factorial {

    static int count = 0;
    private static int findFactorial(int number) {
         int result;
         count ++;
        if (number == 0) {
            return 1;
        }
        result =  number * findFactorial(number -1);
        return result;
    }

    private static long iterativeFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i= 1; i<= number; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    // Tail recursion: https://stackoverflow.com/questions/33923/what-is-tail-recursion

    public static void countWithRepeatetiveCharacter(String str) {
        char[] ch = str.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == ch[j])
                    count++;
            }
        }
//        System.out.print(str.charAt(i) + "" + count);
    }

    public static void main(String[] args) {
        System.out.println(findFactorial(20));
        System.out.println(count);
        System.out.println(iterativeFactorial(100));
        countWithRepeatetiveCharacter("aabbbc");
    }
}
