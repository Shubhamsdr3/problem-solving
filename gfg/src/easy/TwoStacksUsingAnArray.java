package easy;

public class TwoStacksUsingAnArray {

    int size;
    int s1Index;
    int s2Index;
    int[] arr;

    TwoStacksUsingAnArray(int n) {
        arr = new int[n];
        size = n;
        s1Index = -1;
        s2Index = size;
    }

    public void pushToS1(int val) {
        if (s1Index < s2Index -1) {
            s1Index++;
            arr[s1Index] = val;
        } else {
            throw new IndexOutOfBoundsException("index: " + s1Index);
        }
    }

    public void pushToS2() {

    }

}
