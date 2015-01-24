import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Statement

This problem is a programming version of Problem 7 from projecteuler.net

By listing the first six prime numbers: 2,3,5,7,11 and 13, we can see that the 6th prime is 13. 
What is the N'th prime number?

Input Format 
First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.

Output Format 
Print the required answer for each test case.

Constraints 
1≤T≤10^3 
1≤N≤10^4

 */
public class Project_Euler_Plus_Problem_7 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine()); //Parse number of cases
		int[] input = new int[numberOfCases];
		for (int a = 0; a < numberOfCases; a++) { //Import all data
			input[a] = stdin.nextInt(); 
			if (a != numberOfCases - 1){
				stdin.nextLine();
			}
		}
		
		
		//First, we sort the list of input. After this, we can simply go up through numbers, finding primes as we move upward.
		int[] sortedInput = input.clone();
		Arrays.sort(sortedInput);
		
		//Next, we write a method to primeCheck.
		
		int[] nthPrimeNumberArray = new int[sortedInput.length];
		
		int index = 0;
		int primeCounter = 0;
		for(int a = 2; primeCounter < sortedInput[sortedInput.length-1] && index < sortedInput.length; a++){
			if (primeCheck(a)){
				primeCounter++;
				if (primeCounter == sortedInput[index]){
					nthPrimeNumberArray[index] = a;
					index++;
					primeCounter--;
					a--;
				}
			}
		}
		//Now, we have a sorted list of all of the answers. It's a simple task to search the array of answers for the correct value. 
		//If the number of test cases was large, we would use binary search.
		
		for(int a = 0; a < numberOfCases; a++){
			for(int b = 0; b < numberOfCases; b++){
				if (input[a] == sortedInput[b]){
					System.out.println(nthPrimeNumberArray[b]);
					break;
				}
			}
		}
		
		
		
		
	}
	public static boolean primeCheck(int numberToTest){
		for(int a = 2; a <= Math.sqrt(numberToTest); a++){
			if (numberToTest % a == 0){
				return false;
			}
		}
		return true;
	}
}
