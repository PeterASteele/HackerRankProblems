import java.io.*;
import java.util.*;
//World CodeSpring 6, problem 2
//https://www.hackerrank.com/contests/world-codesprint-6/challenges/combination-lock
public class CombinationLock {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		for(int a = 0; a < 5; a++){
			arr1[a] = input.nextInt();
		}
		for(int a = 0; a < 5; a++){
			arr2[a] = input.nextInt();
		}
		int sum = 0;
		for(int a = 0; a < 5; a++){
			sum += Math.min(Math.min(Math.abs(arr1[a]-arr2[a]), Math.abs(arr1[a]+10-arr2[a])),  Math.abs(arr2[a]+10-arr1[a]));
		}
		System.out.println(sum);
	}
}