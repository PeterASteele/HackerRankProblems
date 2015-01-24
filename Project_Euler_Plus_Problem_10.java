import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Statement
 * 
 * This problem is a programming version of Problem 10 from projecteuler.net
 * 
 * The sum of the primes below 10 is 2+3+5+7=17.
 * 
 * Find the sum of all the primes not greater than given N.
 * 
 * Input Format The first line contains an integer T i.e. number of the test
 * cases. The next T lines will contains an integer N.
 * 
 * Output Format Print the value corresponding to each test case in seperate
 * line.
 * 
 * Constraints 1≤T≤104 1≤N≤106
 */
public class Project_Euler_Plus_Problem_10 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine()); // Parse number
																// of cases
		int[] input = new int[numberOfCases];
		for (int a = 0; a < numberOfCases; a++) { // Import all data
			input[a] = stdin.nextInt();
			if (a != numberOfCases - 1) {
				stdin.nextLine();
			}
		}

		// First, we sort the list of input. After this, we can simply go up
		// through numbers, finding primes as we move upward.
		int[] sortedInput = input.clone();
		Arrays.sort(sortedInput);

		// Next, we write a method to primeCheck. (see primecheck method)

		long[] nthPrimeNumberArray = new long[sortedInput.length];
		for (int a = 0; a < numberOfCases; a++) {
			nthPrimeNumberArray[a] = 0;
		}

		for (int a = 2; a <= sortedInput[sortedInput.length - 1]; a++) {
			if (primeCheck(a)) {
				for (int index = 0; index < sortedInput.length; index++) {
					if (a <= sortedInput[index]) {
						nthPrimeNumberArray[index] += a;
					}
				}
			}
		}
		// Now, we have a sorted list of all of the answers. It's a simple task
		// to search the array of answers for the correct value.
		// If the number of test cases was large, we would use binary search.

		for (int a = 0; a < numberOfCases; a++) {
			for (int b = 0; b < numberOfCases; b++) {
				if (input[a] == sortedInput[b]) {
					System.out.println(nthPrimeNumberArray[b]);
					break;
				}
			}
		}

	}

	public static boolean primeCheck(int numberToTest) {
		for (int a = 2; a <= Math.sqrt(numberToTest); a++) {
			if (numberToTest % a == 0) {
				return false;
			}
		}
		return true;
	}
}
