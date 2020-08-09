import java.util.Arrays;
public class BubbleSort {

    private static int[] bubbleSort(int[] list) {
     for (int lastUnsortedIndex = list.length -1; lastUnsortedIndex >= 0; lastUnsortedIndex--) {

         for (int j = 0; j < lastUnsortedIndex; j++) {
             if (list[j] > list[j+1]) {
                 Utils.swapElement(list, j, j+1);
             }
         }
     }
     return list;
    }

    public static void main(String[] args) {
      int[] array = new int[]{20, 35, -15, 7, 55, -22};
      System.out.println(Arrays.toString(bubbleSort(array)));
    }
 }
