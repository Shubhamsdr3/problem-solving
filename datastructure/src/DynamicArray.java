import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {

    /**
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
//    private static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
//
//        return resultList;
//    }

    public static void main(String[] args) {
//        int n = 2;
//        List<Integer> seq1 = new ArrayList<>();
//        seq1.add(1);
//        seq1.add(0);
//        seq1.add(5);
//
//        List<Integer> seq2 = new ArrayList<>();
//        seq2.add(1);
//        seq2.add(1);
//        seq2.add(7);
//
//        List<Integer> seq3 = new ArrayList<>();
//        seq3.add(1);
//        seq3.add(0);
//        seq3.add(3);
//
//        List<Integer> seq4 = new ArrayList<>();
//        seq4.add(2);
//        seq4.add(1);
//        seq4.add(0);
//
//        List<Integer> seq5 = new ArrayList<>();
//        seq5.add(2);
//        seq5.add(1);
//        seq5.add(1);
//
//        List<List<Integer>> inputList = new ArrayList<>();
//        inputList.add(seq1);
//        inputList.add(seq2);
//        inputList.add(seq3);
//        inputList.add(seq4);
//        inputList.add(seq5);
//
//        System.out.println(dynamicArray(n, inputList));

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int numQueries = scan.nextInt();

        List<List<Integer>> seqList = new ArrayList<>(n);
        for (int i = 0; i< n; i++) {
            seqList.add(new ArrayList<>());
        }

        int lastAnswer = 0;
        for (int i=0; i< numQueries; i++) {
            int queryType = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();

            // Find the sequence at index ((x % lastAnswer) % N))
            int index = ((x ^ lastAnswer) % n);

            if (queryType == 1) {
                seqList.get(index).add(y);
            }else  {
                List<Integer> seq = seqList.get((index));
                int index1 = y % seq.size();
                lastAnswer = seq.get(index1);
                System.out.println(lastAnswer);
            }
        }
    }
}
