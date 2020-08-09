package dream11;

public class LargestElement {

    private static int findLargest(int[] arr) {
        int temp = arr[0];

        for (int i=1; i < arr.length; i++) {
            if (temp < arr[i]) {
                temp = arr[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 2, 4, 5};

        int[] arr1 = new int[]{
                434243442, 0, 3, -1, 5000000, 324343232, 324343241, 324343232 , 324343242, 324343246,
                434243442, 434243442, 434243442, 43423442, 5000000, 5000000, 5000000, 5000000, 5000000,
                434043442, 0, 3, -1, 5004000, 324343242, 324343242, 324343242 , 324343242, 324343242,
                434243442, 434243442, 434243442, 434243842, 5000000, 5004000, 5000000, 5010000, 50000001,
                434243442, 0, 3, -1, 5000000, 324343242, 324343242, 324343242 , 324343242, 324343243,
                434243443, 434243440, 434244442, 434243442, 5000001, 5000030, 5400000, 6000000, 5300000};

        System.out.println("first program started.." + System.currentTimeMillis());
        System.out.println(findLargest(arr));
        System.out.println("first program end.." + System.currentTimeMillis());

        System.out.println("----------------");
        System.out.println("second program started.." + System.currentTimeMillis());
        System.out.println(findLargest(arr1));
        System.out.println("second program end.." + System.currentTimeMillis());
    }
}
