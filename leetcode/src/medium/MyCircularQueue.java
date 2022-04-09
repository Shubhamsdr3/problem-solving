package medium;

public class MyCircularQueue {


    private final int[] queue;

    /**
     * to deque the value
     * increment front -> (front + 1) % size
     */
    private int front;

    /**
     * to enqueue element.
     * increment rear -> (rear + 1) % size
     */
    private int rear;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) { // single element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % queue.length; // has more than one element.
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (front == 0 && rear == queue.length - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
    }
}
