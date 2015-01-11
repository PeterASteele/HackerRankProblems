import java.math.BigInteger;
import java.util.Scanner;

public class WeeklyChallenges_Week13_sherlockandanagrams {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		int[] frequency = new int[26];
		Scanner stdin = new Scanner(System.in);
		// Parses the number of cases
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		String caseString = "";
		int sum = 0;
		for (int a = 0; a < numberOfCases; a++) {
			sum = 0;
			caseString = stdin.nextLine();
			for (int start1 = 0; start1 < caseString.length(); start1++) {
				for (int start2 = start1; start2 < caseString.length(); start2++) {
					for(int length = 1; length <= caseString.length() - Math.max(start1,  start2); length++){
						if(start1 != start2){
							String s1 = caseString.substring(start1, start1+length);
							String s2 = caseString.substring(start2, start2+length);
							//System.out.println("Start1 " + start1 + ", Start2 " + start2 + " length " + length);
							if (checkAnagram(s1, s2)) {
								sum++;
								//System.out.println(s1 + " " + s2);
							}
						}											
					}
				}
			}
			System.out.println(sum);
		}
	}

	public static int count(String inputString, char testingChar) {
		int sum = 0;
		for (int a = 0; a < inputString.length(); a++) {
			if (inputString.charAt(a) == testingChar) {
				sum++;
			}
		}
		return sum;
	}
	public static boolean checkAnagram(String s1, String s2){
		boolean anagram = true;
		for(int a = 0; a < 26; a++){
			if (count(s1, (char) (a + 96)) != count(s2, (char) (a + 96))){
				anagram = false;
			}
		}
		return anagram;
	}
}
