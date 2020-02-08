package greedyalgorithm;

public class GoodlandElectricity {

    /**
     * @param k: range
     * @param arr: 1 -> city that can have power plant
     *           0 -> The city which can't have
     * @return :
     */
    private static int pylons(int k, int[] arr) {
        int i = 0;
        int index = 0;
        int count = 0;
        while (i < arr.length) {
            if (arr[i] == 1) {
                index = index + (k - 1);
                count++;
            }
            i++;
        }
        if (index == arr.length) {
            return count;
        } else {
            return -1;
        }
    }


    public static void main(String[] args)  {
        int range = 2;
        int[] inputArray = new int[]{0, 1, 1, 1, 1, 0};
        int range1 = 3;
        int[] inputArray1 = new int[]{0, 1, 1, 1, 0, 0, 0};

        int range2 = 3;
        int[] inputArray2 = new int[]{0, 1, 0, 0, 0, 1, 1, 1, 1, 1};
        System.out.println(pylons(range2, inputArray2));
//        System.out.println(pylons(range1, inputArray1));
    }
}
