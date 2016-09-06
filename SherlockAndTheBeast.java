import java.util.Scanner;
//https://www.hackerrank.com/challenges/sherlock-and-the-beast
public class SherlockAndTheBeast {
	static long[] answerArr = { -2, -1, -1, 555, -1, 33333, 555555, -1,
			55533333, 555555555, 3333333333l, 55555533333l, 555555555555l,
			5553333333333l, 55555555533333l, 555555555555555l };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int tests = input.nextInt();
		for (int a = 0; a < tests; a++) {
			int n = input.nextInt();

			StringBuilder output = new StringBuilder();
			while (n >= 15) {
				n -= 3;
				output.append("555");
			}
			output.append(answerArr[n]);
			System.out.println(output);

		}
	}
}
