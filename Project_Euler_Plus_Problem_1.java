import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/contests/projecteuler/challenges/euler001
/* Problem Statement:
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below N.

Input Format 
First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.

Output Format 
For each test case, print an integer that denotes the sum of all the multiples of 3 or 5 below N.

Constraints 
1≤T≤105 
1≤N≤109
 */
public class Project_Euler_Plus_Problem_1 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		BigInteger sum = new BigInteger("0");
		int caseTemp = 0;
		BigInteger temp = null;
		for (int a = 0; a < numberOfCases; a++) {
			caseTemp = Integer.parseInt(stdin.nextLine()) - 1;
			BigInteger caseTemp2 = new BigInteger("" + caseTemp);
			sum = new BigInteger("0");
			temp = caseTemp2.divide(new BigInteger("3"));
			sum = sum.add(temp.multiply(temp.add(new BigInteger("1")))
					.divide(new BigInteger("2")).multiply(new BigInteger("3")));
			temp = caseTemp2.divide(new BigInteger("5"));
			sum = sum.add(temp.multiply(temp.add(new BigInteger("1")))
					.divide(new BigInteger("2")).multiply(new BigInteger("5")));
			temp = caseTemp2.divide(new BigInteger("15"));
			sum = sum
					.subtract(temp.multiply(temp.add(new BigInteger("1")))
							.divide(new BigInteger("2"))
							.multiply(new BigInteger("15")));
			System.out.println(sum);
		}

	}
}