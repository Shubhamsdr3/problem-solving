package heap;


public class MaxHeap {

    private int[] heapArray;

    private int size;

    private MaxHeap(int capacity) {
        heapArray =  new int[capacity];
    }

    private boolean isFull() {
        return size == heapArray.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("The heap is full");
        }
        heapArray[size] = value;
        fixHeapAbove(size);
        size++;
    }

    /**
     * Why index not value ? : For the value we have to perform the linear search.
     * @param index : Index of the value.
     */
    private void delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty..");
        }
        int parent = getParent(index);
        int deletedValue = heapArray[index];

        // The last element (left most element) is replaced with the deleted value's index.
        heapArray[index] = heapArray[size - 1];

        // Now we will check whether we have to fix the above heap or below heap.
        if (index == 0  && heapArray[index] < heapArray[parent]) {
            // If the deleted node is root node or current value is less than it's parent.
            // then fix the below( obviously).
            fixHeapBelow(index, size -1);
        } else {
            // Means we need to fix above.
            fixHeapAbove(index);
        }
        size --;
    }

    private void sort() {
        int lastHeapIndex = size - 1;
        for (int i=0; i < lastHeapIndex; i++) {
            // Swap the first element with the last one.
            int temp = heapArray[0];
            heapArray[0] =  heapArray[lastHeapIndex - i];
            heapArray[lastHeapIndex -i] = temp;
            fixHeapBelow(0, lastHeapIndex - i -1); // exclude the sorted one element.
        }
    }


    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int leftChild = getLeftChild(index);
            int rightChild = getRightChild(index);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heapArray[leftChild] > heapArray[rightChild] ? leftChild : rightChild); // With greatest one.
                }

                // swap them
                if (heapArray[index] < heapArray[childToSwap]) {
                    int temp = heapArray[index];
                    heapArray[index] = heapArray[childToSwap];
                    heapArray[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                // There is no children
                break;
            }
        }
    }

    private int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return heapArray[0]; // the root element.
    }

    private void fixHeapAbove(int index) {
        int newValue = heapArray[index];
        while (index > 0 && newValue > heapArray[getParent(index)]) {
            heapArray[index] = heapArray[getParent(index)];
            index = getParent(index);
        }
        heapArray[index] = newValue;
    }

    // Traversing heap tree.
    private void printHeapElements() {
        for (int value: heapArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * To get the parent: (index - 1)/2.
     * @param index: The index for which we want the parent.
     * @return : parent's index.
     */
    private int getParent(int index) {
        return (index - 1)/2;
    }

    /**
     * To get the left child: (2 * index +1)
     * @param index: To which we want the left child
     * @return : left child's index.
     */
    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * To get the left child: (2 * index +1)
     * @param index: To which we want the right child
     * @return : right child's index.
     */
    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(80);
        maxHeap.insert(75);
        maxHeap.insert(60);
        maxHeap.insert(68);
        maxHeap.insert(55);
        maxHeap.insert(40);
        maxHeap.insert(52);
        maxHeap.insert(67);
        maxHeap.printHeapElements();
        maxHeap.sort();
        maxHeap.printHeapElements();
//        maxHeap.delete(1);
//        maxHeap.delete(2);
//        maxHeap.printHeapElements();
//        maxHeap.delete(2);
//        System.out.println(maxHeap.peek());

    }
}
