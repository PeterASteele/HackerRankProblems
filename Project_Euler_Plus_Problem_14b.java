import java.util.Scanner;
import java.util.*;

public class Project_Euler_Plus_Problem_14b {
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
		HashMap<Long, Integer> preProcess = preProcessing();
		String input;
		for (int a = 0; a < numberOfCases; a++) {
			input = stdin.nextLine();
			int inputInt = Integer.parseInt(input);
			
			int max = 0;
			int index = 0;
			long index2 = -1 * inputInt;
            if (index2 < -250000){
                index2 = -250000;
            } 
			while(!preProcess.containsKey(index2)){
				index2++;
				//System.out.println(index2);
			}
			System.out.println(preProcess.get(index2));
			
		}
	}
	public static HashMap<Long, Integer> preProcessing(){
		HashMap<Long, Integer> preprocess = new HashMap<Long, Integer>(500000);
		int max = 0;
		int maxIndex = 0;
		for(long a = 1; a < 250000; a++){
			int temp = getLength(a, preprocess);
			preprocess.put(a, temp);
			if (max <= temp ){
				//System.out.println((a * -1) + " " + getLength(a, preprocess));
				preprocess.put(a * -1, (int) a );
				max = temp;
				maxIndex = (int) a;
			}
			else preprocess.put(a*-1, maxIndex);
		}	
		return preprocess;
	}
	public static int getLength(long b, HashMap<Long, Integer> c){
		int count = 0;
		long a = b;
		ArrayList<Long> trail = new ArrayList<Long>();
		while (a != 1){
			trail.add(a);
			if(a%2 == 0){
				a = a/2;
				count++;
			}
			else{
				a = 3 * a + 1;
				count++;
			}
			if (c.containsKey(a)){
				count = count + c.get(a);
				a = 1;
			}
		}
		for(int d = 0; d < trail.size(); d++){
			if(!c.containsKey(trail.get(d))){
			c.put(trail.get(d), count-d);
			//System.out.println(trail.get(d) + "    " + (count-d));
			}
		}
		return count;
		
	}
}



