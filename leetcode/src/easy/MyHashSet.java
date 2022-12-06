package easy;

public class MyHashSet {

    int[] arr;
    int index = 0;

    public MyHashSet() {
        arr = new int[10];
    }

    public void add(int key) {
        if (!contains(key)) {
            arr[index] = key;
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            arr[key] = 0;
        }
    }

    public boolean contains(int key) {
        return true;
    }

    public static void main(String[] args) {

    }
}
