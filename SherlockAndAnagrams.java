import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/sherlock-and-anagrams
public class SherlockAndAnagrams {

  public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int a = 0; a < cases; a++) {
			String sc = input.next();
			int total = 0;
			for (int start = 0; start < sc.length(); start++) {
				for (int start2 = start + 1; start2 < sc.length(); start2++) { 
					for (int length = 1; length < sc.length() - Math.max(start2, start) + 1; length++) {
						if (isAnagram(sc.substring(start2, start2 + length),(sc.substring(start, start + length)))) {
							total++;
						}
					}
				}
			}
			System.out.println(total);
		}
	}

	private static boolean isAnagram(String string1, String string2) {
		int[] freqDist = new int[26];
		for (int a = 0; a < string1.length(); a++) {
			freqDist[string1.charAt(a) - 'a']++;
		}
		for (int b = 0; b < string2.length(); b++) {
			freqDist[string2.charAt(b) - 'a']--;
		}
		for (int c = 0; c < 26; c++) {
			if (freqDist[c] != 0) {
				return false;
			}
		}
		return true;
	}

}