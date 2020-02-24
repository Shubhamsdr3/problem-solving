package hackerearth.febcircuits20;

import java.util.Scanner;

public class SumOfDistance {

    private static double getSumOfDistance(int[] distance) {
        double sum = 0;
        for (int i=0; i < distance.length; i++) {
            for (int j = i+1; j < distance.length; j++) {
                double dist = Math.sin(distance[i] + distance[j]) * Math.cos(distance[i] - distance[j]);
                sum = sum + dist;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for (int i=0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        int[] arr = new int[]{5, 2, 7};
        System.out.printf("%.2f", getSumOfDistance(arr));
    }
}
