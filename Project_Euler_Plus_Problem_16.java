import java.math.BigInteger;
import java.util.Scanner;
/*
 * Problem
Submissions
Leaderboard
Discussions
Problem Statement

This problem is a programming version of Problem 16 from projecteuler.net

29=512 and the sum of its digits is 5+1+2=8.

What is the sum of the digits of the number 2N ?

Input Format 
The first line contains an integer T , i.e., number of test cases. 
Next T lines will contain an integer N.

Output Format 
Print the values corresponding to each test case.

Constraints 
1≤T≤100 
1≤N≤10^4 

Sample Input

3
3
4
7
Sample Output

8
7
11
 */


public class Project_Euler_Plus_Problem_16 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		String input;
		for (int a = 0; a < numberOfCases; a++) {
			input = stdin.nextLine();
			int inputInt = Integer.parseInt(input);
			BigInteger b = (new BigInteger("2")).pow(inputInt);
			String stringOfCharacters = b.toString();
			char[] numericValues = stringOfCharacters.toCharArray();
			int sum = 0;
			for(int c = 0; c < numericValues.length; c++){
				sum += Integer.parseInt("" + numericValues[c]);
			}
			System.out.println(sum);
		}
	}
}
