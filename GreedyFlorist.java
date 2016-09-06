import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/greedy-florist
public class GreedyFlorist {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] test = new int[n];
        for(int a = 0; a < n; a++){
            test[a] = input.nextInt();
        }
        Arrays.sort(test);
        long count = 0;
        for(int a = 0; a < n; a++){
            count += test[n-1-a]*((a/k) + 1);
        }
        System.out.println(count);
    }
}