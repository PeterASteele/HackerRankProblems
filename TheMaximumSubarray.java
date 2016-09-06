import java.io.*;
import java.util.*;
import java.*;
//https://www.hackerrank.com/challenges/maxsubarray
public class TheMaximumSubarray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        for(int a = 0; a < k; a++){
            int n = input.nextInt();
            int[] arr= new int[n];
            int sum = 0;
            int count = 0;
            int max = Integer.MIN_VALUE;
            for(int b = 0; b < n; b++){
                arr[b] = input.nextInt();
                if(arr[b] > max){
                    max = arr[b];    
                }
                if(arr[b] > 0){
                    sum += arr[b];
                    count++;
                }
            }       
            if(count == 0){
                sum = max;
            }
            int subSum = 0;
            int previousRecord = -1000000000;
            for(int b = 0; b < n; b++){
                subSum += arr[b];
                if(subSum > previousRecord){
                    previousRecord=subSum;
                }
                if(subSum < 0){
                    subSum = 0;
                }
            }
            System.out.println(previousRecord+" " + sum);           
        }
    }
}