package marchlunchtime20;

public class ChefSwapsDigits {

    private static long finMaxNumber(int num1, int num2) {
        long max = num1 + num2;
        String str1 =  String.valueOf(num1);
        String str2 = String.valueOf(num2);
        return swap(str1, str2, max);
    }

    private static long swap(String str1, String str2, long max) {
      int i = 0;
      char[] arr1 = str1.toCharArray();
      char[] arr2 = str2.toCharArray();
      while (i < arr1.length) {
          for (int j = 0; j < str2.length(); j++) {
              char temp = arr2[j];
              arr2[j] = arr1[i];
              arr1[i] = temp;
              long sum = Long.parseLong(str1) + Long.parseLong(str2);
              if (sum > max) {
                  max = sum;
              }
          }
      }
      return max;
    }

    public static void main(String[] args) {
        int num1 = 13;
        int num2 = 82;
        System.out.println(finMaxNumber(num1, num2));
    }

}
