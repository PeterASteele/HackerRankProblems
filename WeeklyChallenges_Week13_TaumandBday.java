import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/* Problem Statement
Taum is planning to celebrate the birthday of his friend Diksha. There are two types of gifts that Diksha wants from Taum: one is black and the other is white. To make her happy, Taum has to buy B number of black gifts and W number of white gifts.

The cost of each black gift is X units
and the cost of every white gift is Y units
and the cost of converting each black gift into white or white into black is Z units.
Help Taum by deducing the minimum amount he needs to spend on Diksha's gifts?

Input Format

The first line will contain an integer T which will be the number of test cases.
There will be T pair of lines. The first line of each test case will contain the value of integers B and W. Another line of each test will contain the value of integers X,Y and Z.

Constraints 
1<=T<=10 
0<=X,Y,Z,B,W<=10^9

Output Format

T lines each containing output for a particular test case.
 */
public class WeeklyChallenges_Week13_TaumandBday {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 */
		Scanner stdin = new Scanner(System.in);
		
		//Parses the number of cases
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		int B = 0;
		int W = 0;
		int X = 0;
		int Y = 0;
		int Z = 0;
		BigInteger cost = new BigInteger("0");
		BigInteger bestBlackCost = new BigInteger("0");
		BigInteger bestWhiteCost = new BigInteger("0");
		BigInteger netBlackCost = new BigInteger("0");
		BigInteger netWhiteCost = new BigInteger("0");
		for(int a = 0; a < numberOfCases; a++){
		
		//Parse the value of B and W
		B = stdin.nextInt();
		W = stdin.nextInt();
		stdin.nextLine();
		
		//Parse the value of X, Y, and Z
		X = stdin.nextInt();
		Y = stdin.nextInt();
		Z = stdin.nextInt();
		
		//Find the best cost for a Black or White piece, taking the minimum of the direct cost or the conversion from white to black.
		bestBlackCost = new BigInteger("" + Math.min(X, Y+Z));
		bestWhiteCost = new BigInteger("" + Math.min(Y, X+Z));
		
		netBlackCost = bestBlackCost.multiply(new BigInteger(B + ""));
		netWhiteCost = bestWhiteCost.multiply(new BigInteger(W + ""));
		
		System.out.println(netBlackCost.add(netWhiteCost));
		}
	}
}
