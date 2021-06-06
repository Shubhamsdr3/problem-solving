package easy;

import java.util.ArrayList;
import java.util.List;

public class FizBuzz {

    private static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else  {
                list.add(String.valueOf(i));
            }
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n));
    }

}