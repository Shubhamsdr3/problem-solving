package example;

public class Example2 {

    private final int age;

    Example2(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return 5;
    }

    public static void main(String[] args) {
        int a = 30;
        System.out.println(a << 1);
    }
}
