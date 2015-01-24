import java.math.BigInteger;
import java.util.Scanner;
/*
 * Problem Statement

This problem is a programming version of Problem 8 from projecteuler.net

Find the greatest product of K consecutive digits in the N digit number.

Input Format 
First line contains T that denotes the number of test cases. 
First line of each test case will contain two integers N & K.
Second line of each test case will contain a N digit integer. 

Output Format 
Print the required answer for each test case.

Constraints 
1≤T≤100 
1≤K≤7 
K≤N≤1000
 */
public class Project_Euler_Plus_Problem_8 {
	public static void main(String[] args) {
		//My methodology for my solution is to iterate throught the string, multiplying by the next value and dividing by the value that would no longer be included.
		//  Example for 5 2 as input. * = product, 0 = unused numbers.
		//  **000
		//  0**00
		//  00**0
		//  000**
		// This results in our solution being 0(N) instead of being O(N*k).
	
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		int n;
		int k;
		String input;
		for (int a = 0; a < numberOfCases; a++) {
			n = stdin.nextInt();
			k = stdin.nextInt();
			stdin.nextLine();
			input = stdin.nextLine();
			
			int max = 0;
			int current = 1;
			for(int b = 0; b < k; b++){
				current *= Integer.parseInt("" + input.charAt(b));
			}
			max = current;
					
			for(int b = 1; b < n-k; b++){
				if(Integer.parseInt("" + input.charAt(b-1)) != 0){
					current /= Integer.parseInt("" + input.charAt(b-1));
				}
				else{
					current = 1;
					for(int c = 0; c < k-1; c++){
						current *= Integer.parseInt("" + input.charAt(c + b));
					}
				}
				current *= Integer.parseInt("" + input.charAt(b+k -1));
				if (current > max){
					max = current;
				}
			}	
			System.out.println(max);
		}
	}
}
