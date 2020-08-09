package list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {


    List<Integer>  list = new ArrayList<>(10);
    List<Integer>  list1 = new ArrayList<>();

    private int[] arr;

    private int size;

    ArrayListExample(int size) {
        arr =  new int[size];

        list1.add(10);
    }

    private void addElement(int var) {
        if (arr.length < size) {
            for (int i=0; i < arr.length; i++) {
                arr[i]= var;
            }
        } else {
            arr = new int[size + 16];
        }
    }

    private void printElement() {
        for (int i=0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private void printSize() {
        System.out.println(arr.length);
    }

    public static void main(String[] args) {
        ArrayListExample arr = new ArrayListExample(1);
        arr.addElement(24);
        arr.addElement(26);
        arr.addElement(26);
        arr.addElement(26);
        arr.printElement();
        arr.printSize();
    }
}
