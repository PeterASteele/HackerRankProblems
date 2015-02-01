import java.math.BigInteger;
import java.util.Scanner;

public class Project_Euler_Plus_Problem_15 {
	public static void main(String[] args) {
		int[][] cache1 = new int[501][501];
		Scanner stdin = new Scanner(System.in);
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		
		for (int a = 0; a < numberOfCases; a++) {
			int n = stdin.nextInt();
			int m = stdin.nextInt();
			if( a != numberOfCases-1){
				stdin.nextLine();
			}
			System.out.println(solve(n, m, cache1));
		}
	}
	public static int solve(int n, int m, int[][] cache){
		if((m == 0) || (n == 0)){
			return 1;
		}
		int left = (((cache[n-1][m] != 0) ? cache[n-1][m] : solve(n-1, m, cache)));
		int right = (((cache[n][m-1] != 0) ? cache[n][m-1] : solve(n, m-1, cache)));
		cache[n][m] = (left + right)%1000000007;
		return cache[n][m];
	}
}
