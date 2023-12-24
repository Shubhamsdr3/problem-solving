package easy.data;

public class LinkedQueue {
    private int length;
    private ListNode front;

    private ListNode rear;

    LinkedQueue() {
        length = 0;
        front = rear = null;
    }

    public void enQueue(int data) {
        ListNode node = new ListNode(data);
        if (isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        length++;
    }

    public int deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty queue");
        }
        int result = front.val;
        front = front.next;
        length--;
        if (isEmpty()) {
            rear = null;
        }
        return result;
    }

    public int first() throws Exception {
        if (isEmpty()) throw new Exception();
        return front.val;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
