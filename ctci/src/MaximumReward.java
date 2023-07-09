import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumReward {


    private static int maximizingReward(List<List<Integer>>  lists) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i < lists.size(); i++) {
            for (int j = i+1; j <lists.size(); j++) {
                if (lists.get(i).get(0).equals(lists.get(j).get(0)) || lists.get(i).get(2) + lists.get(j).get(2) == lists.get(i).get(0)) {
                    int reward = lists.get(i).get(1) + lists.get(j).get(1);
                    if (reward > max) {
                        max = reward;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while (testCase > 0) {
            int rows = sc.nextInt();
            for (int i=0; i < rows; i++) {
                List<Integer> list1 = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    list1.add(sc.nextInt());
                }
                list.add(list1);
            }
            System.out.println(maximizingReward(list));

            testCase--;
        }
    }

}
