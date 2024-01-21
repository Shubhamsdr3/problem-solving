package leetcode75.recursion;

public class BacktrackingExample {

    private static void print(int n) {
        if (n < 0) return;
        print(n - 1); // 0, 1, 2, 3, 4
        System.out.println(n);
        print(n - 1); // 4, 3, 2, 1, 0
    }

    public static void main(String[] args) {
        print(4);
    }
}
