import java.math.BigInteger;
import java.util.Scanner;

public class Cavity_Map {
	/*
	 * Problem Statement

You are given a square n×n map. Each cell of the map has a value in it denoting the depth of the appropriate area. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side.

You need to find all the cavities on the map and depict them with character uppercase X.

Input Format

The first line contains an integer n (1≤n≤100), denoting the size of the map. Each of the following n lines contains n positive digits without spaces. A digit (1-9) denotes the depth of the appropriate area.

Output Format

Output n lines, denoting the resulting map. Each cavity should be replaced with character X.
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		String input[] = new String[numberOfCases];
		for (int a = 0; a < numberOfCases; a++) {
			input[a] = stdin.nextLine();
		}
		for (int a = 0; a < numberOfCases; a++) {
			for (int b = 0; b < numberOfCases; b++) {
				if (isOnEdge(a, b, numberOfCases)) {
					input[a] = input[a].substring(0, b) + input[a].charAt(b)
							+ input[a].substring(b + 1, numberOfCases);
				} else {
					input[a] = input[a].substring(0, b)
							+ (isCavity(b, a, input) ? 'X' : input[a].charAt(b))
							+ input[a].substring(b + 1, numberOfCases);
				}
			}
			System.out.println(input[a]);
		}
	}

	public static boolean isOnEdge(int x, int y, int size) {

		return (x == 0 || y == 0 || x == size - 1 || y == size - 1); 
		// x and y cannot be zero or size-1 respectively
	}

	public static boolean isCavity(int x, int y, String[] input) {

		if (input[y].charAt(x - 1) >= input[y].charAt(x)
				|| input[y].charAt(x - 1) == 'X') {
			return false;
		}

		if (input[y].charAt(x + 1) >= input[y].charAt(x)
				|| input[y].charAt(x + 1) == 'X') {
			return false;
		}

		if (input[y - 1].charAt(x) >= input[y].charAt(x)
				|| input[y - 1].charAt(x) == 'X') {
			return false;
		}

		if (input[y + 1].charAt(x) >= input[y].charAt(x)
				|| input[y + 1].charAt(x) == 'X') {
			return false;
		}
		return true;
	}
}
