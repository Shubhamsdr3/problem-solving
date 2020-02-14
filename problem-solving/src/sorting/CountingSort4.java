package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort4 {

    private static void countSort(List<List<String>> arr) {

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("0","6","0","6","4","0","6","0","6","0","4","3","0","1","5", "1","2", "4","2","4"));
        List<String> list1 = new ArrayList<>(Arrays.asList("ab" ,"cd" ,"ef" ,"gh" ,"ij" ,"ab" ,"cd" ,"ef" ,"gh" ,"ij" ,"that" ,"be" ,"to" ,"be" ,"question" ,"or" ,"not" ,"is" ,"to" ,"the"));

        List<List<String>> finalList = new ArrayList<>();
        finalList.add(list);
        finalList.add(list1);
        countSort(finalList);
    }
}
