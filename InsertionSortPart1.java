import java.util.Scanner;
public class InsertionSortPart1 {
/**
 * Insertion Sort 
These challenges will cover Insertion Sort, a simple and intuitive sorting algorithm. We will first start with an already sorted list.

Insert element into sorted list 
Given a sorted list with an unsorted number V in the right-most cell, can you write some simple code to insert V into the array so it remains sorted?

Print the array every time a value is shifted in the array until the array is fully sorted. The goal of this challenge is to follow the correct order of insertion sort.

Guideline: You can copy the value of V to a variable, and consider its cell "empty". Since this leaves an extra cell empty on the right, you can shift everything over until V can be inserted. This will create a duplicate of each value, but when you reach the right spot, you can replace a value with V.

Input Format 
There will be two lines of input:

s - the size of the array
ar - the sorted array of integers
Output Format 
On each line, output the entire array every time an item is shifted in it.

Constraints 
1<=s<=1000 
-10000<=x<= 10000, x  ar
 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int lengthOfList= Integer.parseInt(stdin.nextLine());
		int[] input = new int[lengthOfList];
		for (int a = 0; a < lengthOfList; a++) {
			input[a] = stdin.nextInt();
		}
		int temp = input[lengthOfList-1];
		int a = lengthOfList - 2;
		while(a > -1 && a < lengthOfList && temp < input[a]){ //while position has not been found, we
			input[a+1] = input[a]; //shift the elements over
			for(int b = 0; b < lengthOfList; b++){ //print the list
				System.out.print(input[b] + " ");
			}
			System.out.println();
			a--; //iterate the variable.
		}
		input[a+1] = temp; //set in final position
		for(int b = 0; b < lengthOfList; b++){
			System.out.print(input[b] + " "); //print final list
		}
		System.out.println();
	}
}
