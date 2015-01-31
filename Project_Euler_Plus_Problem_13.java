import java.math.BigInteger;
import java.util.Scanner;

/*
 * Problem Statement

This problem is a programming version of Problem 13 from projecteuler.net

Work out the first ten digits of the sum of N 50-digit numbers.

Input Format 
First line contains N, next N lines contain a 50 digit number each.

Output Format 
Print only first 10 digit of the final sum

Constraints 
1≤N≤103

Sample Input

5
37107287533902102798797998220837590246510135740250
46376937677490009712648124896970078050417018260538
74324986199524741059474233309513058123726617309629
91942213363574161572522430563301811072406154908250
23067588207539346171171980310421047513778063246676
Sample Output

2728190129
 */
public class Project_Euler_Plus_Problem_13 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		String input;
		BigInteger sum = new BigInteger("0");
		for (int a = 0; a < numberOfCases; a++) {
			input = stdin.nextLine();
			sum = sum.add(new BigInteger(input));
		}
		String answer = sum.toString();
		System.out.println(answer.substring(0, 10));
	}

}
