import java.util.*;

public class NonDivisibleSubset {

    private static int nonDivisibleSubset(int k, List<Integer> list) {
        Set<Integer> result = new LinkedHashSet<>();
        for(int i= 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j ++) {
                int sum = list.get(i) + list.get(j);
                if (sum % k != 0) {
                    result.add(list.get(i));
                    result.add(list.get(j));
                }
            }
        }

        for (Integer i: result) {
            for (int m = 1; m < result.size(); m++) {
                int sum = i + result.iterator().next();
                if (sum % k != 0) {

                }
            }
        }

        return result.size();
    }

    private static int subsetPairNotDivisibleByK(int k, List<Integer> list) {
        int maximumSubset;
        int[] remainders = new int[k];
        for(int val: list) {
            int rem = val % k;
            remainders[rem]++;
        }
        if(k % 2 == 0){
            remainders[k/2] = Math.min(remainders[k/2], 1);
        }
        maximumSubset = Math.min(remainders[0], 1);
        for(int i = 1; i <= k/2; i++) {
            maximumSubset += Math.max(remainders[i], remainders[k-i]);
        }
        return maximumSubset;
    }

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(19);
        inputList.add(10);
        inputList.add(12);
        inputList.add(10);
        inputList.add(24);
        inputList.add(25);
        inputList.add(22);
//        int[] inputArray = new int[]{19, 10, 12, 10, 24, 25, 22 };
        System.out.println(subsetPairNotDivisibleByK(4, inputList));
    }
}
