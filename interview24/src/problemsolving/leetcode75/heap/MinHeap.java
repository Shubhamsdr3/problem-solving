package problemsolving.leetcode75.heap;

public class MinHeap <T extends Comparable> extends Heap<T> {

    public MinHeap(Class<T> tClass) {
        super(tClass);
    }

    public MinHeap(Class<T> tClass, int size) {
        super(tClass, size);
    }

    @Override
    protected void shiftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1 ) {
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ? leftIndex : rightIndex;
        } else  if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else if (rightIndex != -1) {
            smallerIndex = rightIndex;
        }
        if (smallerIndex == -1) {
            return;
        }
        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallerIndex, index); // move the minimum to upward.
            shiftDown(smallerIndex);
        }
    }

    @Override
    protected void shiftUp(int index) {
        int parentIndex = getParentIndex(index);
        if(parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
            swap(parentIndex, index);
            shiftUp(parentIndex);
        }
    }

}
