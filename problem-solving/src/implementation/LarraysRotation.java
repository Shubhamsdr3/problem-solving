package implementation;

public class LarraysRotation {

    private static String larrysArray(int[] A) {
        for (int i=0; i < A.length -1; i++) {
            if (A[i] > A[i + 1] ) {
                int[] arr = rotate(A, i,  i + 2);
                if (isSorted(arr)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    private static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        boolean isValid = true;
        for (int i = arr.length -1; i > 0; i--) {
            if (arr[i] < arr[i-1]) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private static int[] rotate(int[] inputArr, int i, int j) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[i+1];
        inputArr[i + 1] = inputArr[j];
        inputArr[j] = temp;
        return inputArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4};
        int[] arr1 = new int[]{1, 3, 4, 2};
        int[] arr2 = new int[]{1, 6, 5, 2, 3, 4};
//        System.out.println(larrysArray(arr));
        System.out.println(larrysArray(arr1));
//        System.out.println(larrysArray(arr2));
    }

}
