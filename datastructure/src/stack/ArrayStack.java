package stack;

import list.Employee;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;

    private int top;

     private ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    private void push(Employee employee) {
        //Check if stack is already full.
        if (top == stack.length) {
            // Resize the array. Cost: O(n).
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top ++] = employee; // cost: O(1)
    }

    private Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Employee employee = stack[--top];
        stack[top] = null; // let the GC do it's job.
        return employee;
    }

    private Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
       return stack[top -1];
    }

    private boolean isEmpty() {
        return top == 0;
    }

    private int getSize() {
        return top;
    }

    private void printStack() {
        for (Employee employee : stack) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);

        for (int i= 0; i < 10; i++) {
            arrayStack.push(new Employee("Shubham " + i, "Pandey"));
        }
        System.out.print("============================");
        arrayStack.printStack();
        System.out.print("Peeking element....");
        System.out.println(arrayStack.peek());

        System.out.print("Poping element....");
        System.out.println(arrayStack.pop());

        arrayStack.printStack();
    }
}
