package easy;

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public QueueUsingStacks() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        peek();
        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.empty());
    }
}
