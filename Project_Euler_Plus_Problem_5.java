import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_Euler_Plus_Problem_5 {
	/*
	 * This problem is a programming version of Problem 5 from projecteuler.net

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder. 
What is the smallest positive number that is evenly divisible(divisible with no remainder) by all of the numbers from 1 to N?

Input Format 
First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.

Output Format 
Print the required answer for each test case.

Constraints 
1≤T≤10 
1≤N≤40
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		int input;
		ArrayList<ArrayList<Integer>> factors = new ArrayList<ArrayList<Integer>>(40);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int a = 1; a < 41; a++){
			temp.clear();
			int number = a;
			int start = 2;
			while (number != 1){
				if (number%start == 0){
					temp.add(start);
					number/=start;
					start--;
				}
				start++;
			}
			factors.add((ArrayList<Integer>) temp.clone());
		}
		/*
		for(ArrayList<Integer> a: factors){
			for(int b: a){
				System.out.print(b);
			}
			System.out.println("");
		}
		*/	
		
		int answer = 1;
		for (int a = 0; a < numberOfCases; a++) {
			input = stdin.nextInt();
			int[] numberOfNumbers = new int[40]; 
			for(int b = 0; b < numberOfNumbers.length; b++){
				numberOfNumbers[b] = 0;
			}
			//All non-prime indexes will be blank.
			//This list will hold the frequency of each prime factor.
			if (a != numberOfCases-1){
				stdin.nextLine();
			}
			for(int b = 1; b < input; b++){
				for(int c = 0; c < 40; c++){
					int total = 0;
					for(int d : factors.get(b)){
						if (d == c){
							total++;
						}
					}
					if (total > numberOfNumbers[c]){
						numberOfNumbers[c] = total;
					}
				}
			}
			answer = 1;
			for(int b = 1; b < numberOfNumbers.length; b++){
				if (numberOfNumbers[b] != 0){
					numberOfNumbers[b]--;
					answer *= b;
					b--;
				}
			}
			System.out.println(answer);
		}
	}
}
