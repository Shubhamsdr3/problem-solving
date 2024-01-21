package problemsolving.leetcode75.heap;

import java.lang.reflect.Array;

public abstract class Heap<T extends  Comparable> {

    private static  int MAX_SIZE = 40;
    private T[] array;

    private int count = 0;

    public  Heap(Class<T> tClass) {
        this(tClass, MAX_SIZE);
    }

    public Heap(Class<T> tClass, int size) {
        array = (T[]) Array.newInstance(tClass, size);
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1; // left child.
        if (leftChildIndex >= count) {
            return -1; // no left child.
        }
        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2; // right child.
        if (rightChildIndex >= count) {
            return -1; // no left child.
        }
        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if(index < 0 || index > count) {
            return -1;
        }
        return (index - 1)/ 2; // parent.
    }

    protected  void swap(int index1, int index2) {
        T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    protected void insert(T value) {
        if (count >= array.length) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        array[count] = value;
        shiftUp(count); // bcz we added the element at the leaf node.
        count++;
    }

    private T removeHighestPriority(T value) {
        if (isEmpty()) throw new IndexOutOfBoundsException("Heap is empty");
        T result = getHighestPriorityElement();
        array[0] = array[array.length - 1];
        count--;
        shiftDown(0);
        return result;
    }

    private T getHighestPriorityElement() {
        return array[0]; // due to minimum heap.
    }

    protected abstract void shiftDown(int index);
    protected abstract void shiftUp(int index);

}
