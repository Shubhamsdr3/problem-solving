package contest176;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    private static List<Integer> list = new ArrayList<>();

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int product = 1;
        int n = list.size();
        for (int i = n - 1; i >= n-k; i--) {
            product = product * list.get(i);
        }
        return product;
    }

    public static void main(String[] args) {
        ProductOfNumbers pd= new ProductOfNumbers();
        pd.add(3);
        pd.add(0);
        pd.add(2);
        pd.add(5);
        pd.add(4);
        System.out.println(pd.getProduct(2));
        System.out.println(pd.getProduct(3));
        System.out.println(pd.getProduct(4));
        pd.add(8);
        System.out.println(pd.getProduct(2));
    }
}
