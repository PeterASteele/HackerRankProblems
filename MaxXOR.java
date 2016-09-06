import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/maximizing-xor
public class MaxXOR {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int e = input.nextInt();
        int max = 0;
        for(int k = n; k <= e; k++){
            for(int j = n; j<= e; j++){
                if(max < (j^k)){
                    max = (j^k);
                }
            }
        }
        System.out.println(max);
    }
}