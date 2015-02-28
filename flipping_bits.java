import java.math.BigInteger;
import java.util.Scanner;

public class flipping_bits {
	public static void main(String[] args) {
		/*
		 *	Problem Statement

You will be given a list of 32 bits unsigned integers. You are required to output the list of the unsigned integers you get by flipping bits in its binary representation (i.e. unset bits must be set, and set bits must be unset).

Input Format

The first line of the input contains the list size T. T lines follow each line having an integer from the list.

Constraints

1≤T≤100 
0≤integer<232
Output Format

Output one line per element from the list with the requested result. 
		 */
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		String input;
		BigInteger intInput;
		BigInteger output;
		for (int a = 0; a < numberOfCases; a++) {
			input = stdin.nextLine();
			
			intInput = new BigInteger(input);
			
			output = ((new BigInteger("4").multiply(new BigInteger( "" + ((int) Math.pow(2,30)))).subtract(new BigInteger("1"))).subtract(intInput));
			System.out.println(output.toString());
		}
		

	}

}
