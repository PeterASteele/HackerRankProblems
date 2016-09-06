import java.io.*;
import java.util.*;
//World CodeSpring 6, problem 1
//https://www.hackerrank.com/contests/world-codesprint-6/challenges/bon-appetit
public class BonAppetit {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int[] arr = new int[n];
		for(int a = 0; a < n; a++){
			arr[a] = input.nextInt();
		}
		
		long sum = 0;
		for(int a = 0; a < n; a++){
			sum += arr[a];
		}
		sum -= arr[k];
		sum = sum/2;
		long val = input.nextInt();

		if(sum == val){
			System.out.println("Bon Appetit");
		}
		else{
			System.out.println(val-sum);
		}
	}
}