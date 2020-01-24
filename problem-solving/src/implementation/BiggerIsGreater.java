package implementation;

public class BiggerIsGreater {

    private static String biggerIsGreater(String w) {
        boolean isPossible = false;
        char[] arr = w.toCharArray();
        if (isAllCharactersEqual(arr)) {
            return "no answer";
        }
        for (int i=arr.length -1; i > 0; i--) {
            if (arr[i] > arr[i-1]) {
                swap(arr, i, i-1);
                isPossible = true;
                break;
            } else {
                int index = findShortest(arr, i, arr.length-1);
                swap(arr, i, index);
            }
        }
        if (!isPossible) {
            return "no answer";
        }
        return getStringFromCharArray(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int findShortest(char[] arr, int i, int j) {
        int index = j;
        for (int s = j; s > i; s--) {
            if (arr[s-1] < arr[index]) {
                index = s-1;
            }
        }
        return index;
    }

    private static String getStringFromCharArray(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static boolean isAllCharactersEqual(char[] arr) {
        for (int j=arr.length-1; j > 0; j--) {
            if (arr[j] != arr[j-1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isContains(char[] arr, char c){
        for (char ch: arr) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] arr) {
        String string = "ab";
        String string1 = "bb";
        String string2 = "hefg";
        String string3 = "dhck";
        String string4 = "dkhc";
        System.out.println(biggerIsGreater(string));
        System.out.println(biggerIsGreater(string1));
        System.out.println(biggerIsGreater(string2));
        System.out.println(biggerIsGreater(string3));
        System.out.println(biggerIsGreater(string4));
    }
}
