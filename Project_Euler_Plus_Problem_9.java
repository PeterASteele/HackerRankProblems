import java.math.BigInteger;
import java.util.Scanner;
/*
 * Problem Statement

This problem is a programming version of Problem 9 from projecteuler.net

A Pythagorean triplet is a set of three natural numbers, a<b<c, for which,
a2+b2=c2
For example, 32+42=9+16=25=52
Given N, Check if there exists any Pythagorean triplet for which a+b+c=N 
Find maximum possible value of abc among all such Pythagorean triplets, If there is no such Pythagorean triplet print −1.

Input Format 
The first line contains an integer T i.e. number of test cases. 
The next T lines will contain an integer N.

Output Format 
Print the value corresponding to each test case in seperate line.

Constraints 
1≤T≤3000 
1≤N≤3000
 * 
 *
 */
public class Project_Euler_Plus_Problem_9 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		int input[] = new int[numberOfCases];
		for (int a = 0; a < numberOfCases; a++) {
			input[a] = stdin.nextInt();
			
			if(a < numberOfCases -1){
				stdin.nextLine();
			}
			
			double minHypo = Math.sqrt(2.0)/(2 + Math.sqrt(2.0)) * input[a];
			double maxHypo = input[a]/2.0;
			//System.out.println(minHypo + " " + maxHypo);
			int d;
			int max = 0; 
			for(int b = (int) minHypo; b < (int) maxHypo; b++){
				//System.out.println(b);
				for(int c = 1; c <= (input[a]-b)/2; c++){
					d = input[a] - b - c;
					//System.out.println("c is " + c + " d is " + d + " b is " + b + " " + (c * c + d * d == b * b));
					if (c * c + d * d == b * b && c * d * b > max){
						max = c * d * b;
					}
					//b is hypotenuse
					//c,d are legs
					
				}			
			}
			System.out.println(max);
		}
	}
}
