import java.util.Scanner;
import java.util.*;

public class Project_Euler_Plus_Problem_14 {
	/*
	 * Problem Statement

	This problem is a programming version of Problem 14 from projecteuler.net

	The following iterative sequence is defined for the set of positive integers:

	nn→n2→3n+1 n is even  n is odd 
	Using the rule above and starting with 13, we generate the following sequence:

	13→40→20→10→5→16→8→4→2→1
	It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

	Which starting number, ≤N produces the longest chain? If many possible such numbers are there print the maximum one.

	Note: Once the chain starts the terms are allowed to go above N.

	Input Format 
	The first line contains an integer T , i.e., number of test cases. 
	Next T lines will contain an integers N.

	Output Format 
	Print the values corresponding to each test case.

	Constraints 
	1 ≤ T ≤ 10^4
	1 ≤ N ≤ 5*10^6
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		ArrayList<Integer> preProcess = preProcessing();

		String input;
		for (int a = 0; a < numberOfCases; a++) {
			input = stdin.nextLine();
			int inputInt = Integer.parseInt(input);
			long index2 = inputInt;
			System.out.println(preProcess.get((int) index2));

		}
	}

	public static ArrayList<Integer> preProcessing() {
		ArrayList<Integer> length = new ArrayList<Integer>(200000);
		ArrayList<Integer> maxIndexes = new ArrayList<Integer>(200000);
		length.add(0, 0);
		maxIndexes.add(0);
		int max = 0;
		int maxIndex = 1;
		for (int a = 1; a < 100000; a++) {
			int temp = getLength(a, length); // /
			length.add(a, temp);
			if (max <= temp) {
				max = temp;
				maxIndex = (int) a;
			}
			maxIndexes.add(a, maxIndex);
		}
		return maxIndexes;
	}

	public static int getLength(int b, ArrayList<Integer> length) {
		int count = 0;
		int a = b;
		ArrayList<Long> trail = new ArrayList<Long>();
		while (a != 1) {
			trail.add((long) a);
			if (a % 2 == 0) {
				a = a / 2;
				count++;
			} else {
				a = 3 * a + 1;
				count++;
			}
			if (a > 0 && a < 2147000000 && a <= length.size()) {
				if (length.get((int) a) != null) {
					count = count + length.get((int) a);
					a = 1;
				}
			}
		}
		for (int d = 0; d < trail.size(); d++) {
			if (trail.get(d) < 2147000000
					&& ((int) (long) trail.get(d)) < length.size()
					&& length.get((int) (long) trail.get(d)) == null) {
				length.add((int) (long) trail.get(d), count - d);
				// System.out.println(trail.get(d) + "    " + (count-d));
			}
		}
		return count;

	}
}
