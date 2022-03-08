package easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> input = new LinkedList<>();

    public void push(int x) {
        input.add(x);
        for (int i =0; i < input.size() - 1; i++) {
            input.add(input.poll());
        }
    }

    public int pop() {
        return input.poll();
    }

    public int top() {
        return input.peek();
    }

    public boolean empty() {
        return input.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
    }
}
