package queue;

import list.Employee;

import java.util.NoSuchElementException;

/**
 * Array implementation of Queue.
 */
public class ArrayQueue {

    /**
     * Will point the array of employee.
     */
    private Employee[] queue;

    /**
     *
     */
    private int front;

    /**
     * Will point to next available position in array like top in stack.
     */
    private int back; // tail. could say.

    ArrayQueue(int capacity) {
        queue =  new Employee[capacity];
    }

    public void add(Employee employee) {
        if (back == queue.length) {
            // Here is the problem which is solved in CircularQueue.
            // add employee1
            // add employee2
            // remove()
            // back will still be 3rd while we have removed one item.
            System.out.println("Resizing the array...");
            Employee[] employees =  new Employee[2 * queue.length];
            System.arraycopy(queue, 0, employees, 0,queue.length);
            queue = employees;
        }
        queue[back] = employee;
        back ++;
    }

    public Employee remove() {
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
        }
        return employee;
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i= front; i < back; i++ ){
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Shubham1", "Pandey1");
        Employee employee2 = new Employee("Shubham2", "Pandey2");
        Employee employee3 = new Employee("Shubham3", "Pandey3");

        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.add(employee1);
        arrayQueue.add(employee2);
        arrayQueue.add(employee3);
        arrayQueue.printQueue();
        System.out.println("Removed Item..." + arrayQueue.remove());
        arrayQueue.printQueue();
    }
}
