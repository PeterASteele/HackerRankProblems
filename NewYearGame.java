import java.util.Scanner;
//https://www.hackerrank.com/contests/hourrank-4/challenges/newyear-game
public class NewYearGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		while (testCases > 0) {
			testCases--;
			int n = input.nextInt();
			boolean[] inputLine = new boolean[3];
			for (int a = 0; a < n; a++) {
				int temp = input.nextInt();
				inputLine[temp%3] = !inputLine[temp%3];
			}
			if((!inputLine[1]) && (!inputLine[2])){
				System.out.println("Koca");
			}
			else{
				System.out.println("Balsa");
			}
			
			
			
		}
	}
}
