import java.util.Scanner;

//https://www.hackerrank.com/contests/hourrank-4/challenges/new-year-party
public class NewYearParty {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] inputTimes = new int[n];
		for(int a = 0; a < n; a++){
			inputTimes[a] = input.nextInt();
		}
		int time = 0;
		for(int a = 0; a < n; a++){
			time = Math.max(time+1, inputTimes[a]);
		}
		System.out.println(time);
	}
}
