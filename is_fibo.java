import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class is_fibo {
	public static void main(String[] args) {
		/*
		 * Problem Statement

You are given an integer, N. Write a program to determine if N is an element of the Fibonacci Sequence.

The first few elements of fibonacci sequence are 0,1,1,2,3,5,8,13,⋯ A fibonacci sequence is one where every element is a sum of the previous two elements in the sequence. The first two elements are 0 and 1.

Input Format 
The first line contains T, number of test cases. 
T lines follows. Each line contains an integer N.

Output Format 
Display IsFibo if N is a fibonacci number and IsNotFibo if it is not a fibonacci number. The output for each test case should be displayed in a new line.

Constraints 
1≤T≤10^5 //Number of test cases can be anywhere up to 10,000
1≤N≤10^10 // Size of number can be anything from 1 to 10,000,000,000 (use long data structure).
Sample Input

3 //number of test cases
5
7
8
Sample Output

IsFibo
IsNotFibo
IsFibo
		 */
		Scanner stdin = new Scanner(System.in);
		
		long[] fibo = new long[1000];//fibonacci has an approximate lower bound of 1.5^n, so 1000 elements should be more than enough. 
		fibo[0] = 0;
		fibo[1] = 1;
		long x = fibo[0] + fibo[1];
		
		int iterator = 2;
		while(x < 10000000000L){ //Inside this loop, we preprocess the values of fibonacci up to 10,000,000,000
			fibo[iterator] = fibo[iterator-1] + fibo[iterator-2];
			iterator++;
			x = fibo[iterator-1];
			//System.out.println(fibo[iterator-1]);
		}
		Arrays.sort(fibo);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		String input;
		BigInteger intInput;
		BigInteger output;
		for (int a = 0; a < numberOfCases; a++) {
			input = stdin.nextLine();
			long inputLong = Long.parseLong(input, 10);
			
			if(Arrays.binarySearch(fibo, inputLong) < 0){
			//	System.out.println("InputLong is fibo" + inputLong);
				System.out.println("IsNotFibo");
			}
			else{
				//System.out.println("InputLong is not fibo" + inputLong);
				System.out.println("IsFibo");
			}
		}
		

	}
}
