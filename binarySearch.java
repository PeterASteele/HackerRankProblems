import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Given a sorted array (ar) and a number (V), can you print the index location of V in the array?

{The next section describes the input format. You can often skip it, if you are using included methods. }

Input Format 
There will be three lines of input:

V - the value that has to be searched.
n - the size of the array.
ar - n numbers that make up the array.
Output Format 
Output the index of V in the array.

{The next section describes the constraints and ranges of the input. You should check this section to know the range of the input. }

Constraints 
1<=n<=1000 
-1000 <=x <= 1000 , x ∈ ar
 */
public class binarySearch { //Usage of the binary search function in java. 
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberToSearch = stdin.nextInt();
		stdin.nextLine();
		int sizeOfArray = Integer.parseInt(stdin.nextLine());
		int[] input = new int[sizeOfArray];
		for (int a = 0; a < sizeOfArray; a++) {
			input[a] = stdin.nextInt();
		}
		
		System.out.println(Arrays.binarySearch(input, numberToSearch));
	}
}
