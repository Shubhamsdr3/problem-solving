package medium;

import java.util.ArrayList;
import java.util.List;

public class EliminationGame {

    //My version
    private static int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i <= n; i++) {
            list.add(i);
        }
        while (list.size() > 1) {
            int i = 0;
            while (i < list.size()) {
                list.remove(i);
                i = i + 1;
            }
            int j = list.size() - 1;
            while (j > 0) {
                list.remove(j);
                j = j - 2;
            }
        }
        return list.get(0);
    }

    private static int lastRemaining1(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(lastRemaining1(n));
    }
}
