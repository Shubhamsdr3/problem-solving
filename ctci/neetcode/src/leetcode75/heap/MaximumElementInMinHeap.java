package leetcode75.heap;

public class MaximumElementInMinHeap {

    /**
     * In min heap of n elements, there is ceil(n/2) leaf nodes.
     * Ge
     * @param heap
     * @param n
     * @return
     */
    private static int findMaxInMinHeap(int[] heap, int n) {
        int maxElement = heap[n / 2];
        // the fist leaf node index and then traverse all the leaf nodes.
        // bcz in min-heap all the maximum elements will be leaf nodes.
        for (int i = 1 + n / 2; i < n; i++) {
            maxElement = Math.max(maxElement, heap[i]);
        }
        return maxElement;
    }

    private static int getMax(MinHeap<Integer> minHeap) {
        int lastIndex = minHeap.getCount() - 1;
        int lastPrentIndex = minHeap.getParentIndex(lastIndex);
        int firstChildIndex = lastPrentIndex + 1;
        int maxElement = minHeap.getElementAtIndex(firstChildIndex);
        for (int i = firstChildIndex; i <= lastIndex; i++) {
            if (maxElement < minHeap.getElementAtIndex(i)) {
                maxElement = minHeap.getElementAtIndex(i);
            }
        }
        return maxElement;
    }
}
