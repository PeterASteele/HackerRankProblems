import java.util.Scanner;
/*
 * Problem Statement

This problem is a programming version of Problem 18 from projecteuler.net

By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23. The path is denoted by numbers in bold.

3 
74 
246 
8593

That is, 3+7+4+9=23.

Find the maximum total from top to bottom of the triangle given in input.

Input 
First line contains T, the number of testcases. For each testcase: 
First line contains N, the number of rows in the triangle. 
For next N lines, i'th line contains i numbers.

Output 
For each testcase, print the required answer in a newline.

Constraints 
1≤T≤10 
1≤N≤15 
numbers∈[0,100)
 */
public class Project_Euler_Plus_Problem_18 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		String input;
		for (int a = 0; a < numberOfCases; a++) {
			int b = stdin.nextInt();
			int[][] inputArray = new int[b][b];
			for(int c = 0;  c < b; c++){
				for(int d = 0; d <= c; d++){
					inputArray[c][d] = stdin.nextInt();
				}
			}
			int max = 0;
			int count = 0;
			int sum = 0;
			int index = 0;
			while(count < Math.pow(2, b)){
				sum = 0;
				index = 0;
				for(int c = 0; c < b; c++){
					sum += inputArray[c][index];
					int d = (int) (count / Math.pow(2, c));
					d = d%2;
					index += d;	
				}
				if(max < sum){
					max = sum;
				}
				count++;
			}
			System.out.println(max);
		}
	}
}
