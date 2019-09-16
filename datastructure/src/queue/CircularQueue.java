package queue;

import list.Employee;

import java.util.NoSuchElementException;

public class CircularQueue {

    /**
     * Will point the array of employee.
     */
    private Employee[] queue;

    /**
     * This will point front of the queue from where elements are removed.
     */
    private int front;

    /**
     * Will point to next available position in array like top in stack.
     * Elements are removed from this position.
     */
    private int back; // tail. could say.

    public CircularQueue(int capacity) {
        queue = new Employee[capacity];
    }

    private void circularAdd(Employee employee) {
        if (size() == queue.length -1) {
            System.out.println("Resizing the array...");
            int numOfItems = size();
            Employee[] newArray =  new Employee[2 * queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;
            front = 0;
            back = numOfItems;
        }
        queue[back] = employee;
        if (back < queue.length - 1) {
            back ++;
        } else {
            back = 0;
        }
    }

    private Employee circularRemove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Employee employee =  queue[front]; // The element to remove.
        queue[front] = null; // let GC do his work.
        front ++;

        // If employee is the only element we are removing, reset the queue.
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }

        return employee;
    }

    private int size() {
        if (front <=  back) {
            // Queue has not bee wrapped.
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    private void printCircularQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            // Print the element from front to end of the queue.
            for (int j =  front; j < queue.length; j++) {
                System.out.println(queue[j]);
            }
            // print the rest of the elements
            for (int k =  0; k < back; k++) {
                System.out.println(queue[k]);
            }
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Shubham1", "Pandey1");
        Employee employee2 = new Employee("Shubham2", "Pandey2");
        Employee employee3 = new Employee("Shubham3", "Pandey3");

        CircularQueue arrayQueue = new CircularQueue(10);
        arrayQueue.circularAdd(employee1);
        arrayQueue.circularAdd(employee2);
        arrayQueue.circularAdd(employee3);
        arrayQueue.printCircularQueue();
        System.out.println("Removed Item..." + arrayQueue.circularRemove());
        arrayQueue.printCircularQueue();
    }
}
