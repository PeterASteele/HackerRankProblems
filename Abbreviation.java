import java.io.*;
import java.util.*;

//World CodeSpring 6, problem 4
//https://www.hackerrank.com/contests/world-codesprint-6/challenges/abbr
public class Abbreviation {

   static HashMap<Long, Boolean> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int q = input.nextInt();
		for (int a = 0; a < q; a++) {

			map = new HashMap<Long, Boolean>();
			String strA = input.next();
			String strB = input.next();
			int idxA = 0;
			int idxB = 0;
			boolean OK = solve(strA, strB, idxA, idxB);
			//System.out.println(map);
			if(OK){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
	}

	private static boolean solve(String strA, String strB, int idxA, int idxB) {
		if(map.containsKey(hash(idxA, idxB))){
			return map.get(hash(idxA, idxB));
		}
		if(idxA == strA.length() && idxB == strB.length()){
			//System.err.println(idxA + " " + idxB + " Good, both are done");
			return true;
		}
		if(idxA == strA.length() && idxB != strB.length()){

			//System.err.println(idxA + " " + idxB + " BAD, A finished before B");
			return false;
		}
		if(idxB == strB.length() && idxA != strA.length()){

			//System.err.println(idxA + " " + idxB + " removing lowercase");
			//try and remove the rest of the strA's letters.
			boolean OK = false;
			if(isLowerCase(strA.charAt(idxA))){
				OK = solve(strA, strB, idxA+1, idxB);
			}			
			map.put(hash(idxA, idxB), OK);
			return OK;
		}
		
		if(isLowerCase(strA.charAt(idxA))){
			//remove it or match
			//System.err.println(idxA + " " + idxB + " Lowercase");
			boolean OK = solve(strA, strB, idxA+1, idxB);
			if(strA.charAt(idxA) == strB.charAt(idxB)-'A'+'a'){
				OK = OK || solve(strA, strB, idxA+1, idxB+1);
			}
			map.put(hash(idxA, idxB), OK);
			return OK;
		}
		else{
			//System.err.println(idxA + " " + idxB + " Uppercase");
			boolean OK = false;
			if(strA.charAt(idxA) == strB.charAt(idxB)){
				OK = OK || solve(strA, strB, idxA+1, idxB+1);
			}
			map.put(hash(idxA, idxB), OK);
			return OK;
		}
	}

	private static boolean isLowerCase(char charAt) {
		if(charAt-'a' >= 0 && charAt-'a' <= 25){
			return true;
		}
		return false;
	}

	public static long hash(int a, int b) {
		return a * 1000000000l + b;
	}
}