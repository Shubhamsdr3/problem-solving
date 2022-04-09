package medium;

public class FrontMiddleBackQueue {

    private final int[] queue;
    private int front;
    private int rear;

    public FrontMiddleBackQueue() {
        queue = new int[10];
        front = 0;
        rear = 0;
    }

    public void pushFront(int val) {
        queue[front] = val;
        front++;
    }

    public void pushMiddle(int val) {
        int mid = queue.length / 2;
        queue[mid] = val;
    }

    public void pushBack(int val) {
         
    }

    public int popFront() {
        return 0;
    }

    public int popMiddle() {
        return 0;
    }

    public int popBack() {
        return 0;
    }

    public static void main(String[] args) {

    }
}
