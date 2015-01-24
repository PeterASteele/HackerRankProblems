import java.math.BigInteger;
import java.util.Scanner;

/*
 * Problem Statement

This problem is a programming version of Problem 6 from projecteuler.net

The sum of the squares of the first ten natural numbers is, 12+22+...+102=385. The square of the sum of the first ten natural numbers is, (1+2+⋯+10)2=552=3025. Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025−385=2640.

Find the difference between the sum of the squares of the first N natural numbers and the square of the sum.

Input Format 
First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.

Output Format 
Print the required answer for each test case.

Constraints 
1≤T≤10^4 
1≤N≤10^4
 */
public class Project_Euler_Plus_Problem_6 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		BigInteger input = new BigInteger("0");
		for (int a = 0; a < numberOfCases; a++) {
			input = new BigInteger("" + stdin.nextInt());
			if( a != numberOfCases - 1){
				stdin.nextLine();
			}
			BigInteger sumOfSquares = input.pow((int) 3).divide(new BigInteger("3")).add(input.pow((int) 2).divide(new BigInteger("2")).add(input.pow((int) 1).divide(new BigInteger("6"))));
			BigInteger squareOfSum = (input.multiply(input.add(new BigInteger("1")))).pow(2).divide(new BigInteger("4")); 
			
			BigInteger roundedOffAnswer = squareOfSum.subtract(sumOfSquares);
			//Compensating for rounding error by using bigInteger remainders
			BigInteger remaindersCubed = (input.pow((int) 3).remainder(new BigInteger("3"))).multiply(new BigInteger("2"));
			BigInteger remaindersSquared = (input.pow((int) 2).remainder(new BigInteger("2"))).multiply(new BigInteger("3"));;
			BigInteger remainders = (input.pow((int) 1).remainder(new BigInteger("6")));
			BigInteger answer = roundedOffAnswer.subtract(remaindersCubed.add(remaindersSquared.add(remainders)).divide(new BigInteger("6")));				
			System.out.println(answer);
		}
	}
}
//Sum of squares formula n^3/3 + n^2/2 + n/6
