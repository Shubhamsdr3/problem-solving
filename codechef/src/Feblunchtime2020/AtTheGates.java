package Feblunchtime2020;

import java.util.Scanner;
import java.util.Stack;

public class AtTheGates {

    private static void getCharacter(Stack<Character> stack, int k) {
        while (k > 0) {
            Character c = stack.pop();
            if (c == 'H') {
                for (int i = 0; i < stack.size(); i++) {
                    if (stack.get(i) == 'H') {
                        stack.set(i, 'T');
                    } else {
                        stack.set(i, 'H');
                    }
                }
            }
            k--;
        }
        int count = 0;
        while (!stack.isEmpty()){
            if (stack.pop() == 'H') {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while (sc.hasNext()) {
            int testCases = sc.nextInt();
            while (testCases > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                Stack<Character> stack = new Stack<>();
                for (int i=0; i < n; i++) {
                    stack.add(sc.next().charAt(0));
                }
                getCharacter(stack, k);
                testCases--;
            }
        }
    }
}
