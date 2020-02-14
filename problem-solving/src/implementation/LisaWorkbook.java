package implementation;

public class LisaWorkbook {

    /**
     * @param n: the number of chapters
     * @param k : Number of maximum problems per page
     * @param arr : Number of problems in each chapter
     * @return
     */
    private static int workbook(int n, int k, int[] arr) {
        int pageNumber = 1;
        int specialCount  = 0;
        for (int a : arr) {
            for (int j = 1; j <= a; j++) {
                if (j == pageNumber) {
                    specialCount++;
                }
                if (j % k == 0) {
                    pageNumber++;
                }
            }
            if (a % k != 0) {
                pageNumber++;
            }
        }
        return specialCount;
    }

    public static void main(String[] args) {
        int n = 15;
        int k = 20;
        int[] inputArray = new int[]{1, 8, 19, 15, 2, 29, 3, 2, 25, 2, 19, 26, 17, 33, 22};
        System.out.println(workbook(n, k, inputArray));
    }
}
