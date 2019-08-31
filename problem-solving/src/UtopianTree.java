public class UtopianTree {

    static int utopianTree(int n) {
        int height =1;
        if (n == 0) {
            return height;
        }
        for(int i=1; i<= n; i++) {
            if(i % 2 == 0) {
                height = height + 1;
            } else {
                height = height * 2;
            }
        }
        return height;
    }

    public static void main(String[] args) {
        System.out.println(utopianTree(0));
        System.out.println(utopianTree(1));
        System.out.println(utopianTree(4));
    }
}
