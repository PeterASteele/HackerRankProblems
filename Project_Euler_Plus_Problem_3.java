import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;
/*
 * Problem Statement

This problem is a programming version of Problem 3 from projecteuler.net

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of a given number N?

Input Format 
First line contains T, the number of test cases. This is followed by T lines each containing an integer N.

Output Format 
For each test case, display the largest prime factor of N.

Constraints 
1≤T≤10 
10≤N≤10^12
 */
public class Project_Euler_Plus_Problem_3 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		//Parse the number of cases
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		Long input;
		
		//If there was a large number of test cases, we would maintain an arrayList of prime numbers to save computation time. Because there are only ten, we shouldn't.
		//The code commented out is what I would do with a larger test case, although I'd avoid repeats in my prime list.
		//Note: We only have to check up to the square root, because if we havn't found a factor below the square root of a number the number must be prime!
		
		/*
		ArrayList<Long> listOfPrimes = new ArrayList<Long>(10000); //Starting that arraylist off fairly large to increase speed.
		boolean isPrime = true;
		long max = -1;
		for (int a = 0; a < numberOfCases; a++) {
			input = new Long(stdin.nextLine());
			for(long b = 2; b <= Math.sqrt(input); b++){
				isPrime = true;
				for(long primeCheck : listOfPrimes){
					if (b % primeCheck == 0){
						isPrime = false;
						break;
					}
				}
				if (isPrime){
					listOfPrimes.add(b);
				}
				if (isPrime && input % b == 0){
					max = b;
					input /= b;
					b--;
				}
			}
			System.out.println(Math.max(input, max));
		}
		*/	
		
		long max = -1;
		for (int a = 0; a < numberOfCases; a++) {
			input = new Long(stdin.nextLine());
			for(long b = 2; b <= Math.sqrt(input); b++){
				if (input % b == 0){
					max = b;
					input /= b;
					b--;
				}
			}
			System.out.println(Math.max(input, max));
		}
	}
}


