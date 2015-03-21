import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClockPictures {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int hands = input.nextInt();
		int[] clock1 = new int[hands];
		int[] clock2 = new int[hands];
		for (int a = 0; a < hands; a++) {
			clock1[a] = input.nextInt();
		}
		for (int a = 0; a < hands; a++) {
			clock2[a] = input.nextInt();
		}
		Arrays.sort(clock1);
		Arrays.sort(clock2);
		ArrayList<Integer> possibilities = new ArrayList<Integer>();
		if (clock1.length > 10) {
			for (int a = 0; a < hands; a++) {
				int difference = (clock1[a] - clock2[0] + 360) % 360;
				boolean temp = true;
				for (int x = 0; x < hands; x++) {
					if ((clock1[(a + x) % hands] - clock2[x] + 360) % 360 != difference) {
						temp = false;
						break;
					}
				}
				if(temp == true){
					possibilities.add(a);
				}
			}
		} else {
			for (int a = 0; a < hands; a++) {
				possibilities.add(a);
			}
		}
		// System.out.println(possibilities);
		if (possibilities.isEmpty()) {
			System.out.println("impossible");
		} else {
			for (int a = 0; a < possibilities.size(); a++) {
				if (checkClocks(clock1, clock2, possibilities.get(a))) {
					System.out.println("possible");
					return;
				}
			}
			System.out.println("impossible");
		}
	}

	public static boolean checkClocks(int[] clock1, int[] clock2, int index) {
		int difference = (clock1[index] - clock2[0] + 360) % 360;
		for (int a = 0; a < clock1.length; a++) {
			if (difference != (clock1[(index + a) % clock1.length] - clock2[a] + 360) % 360) {
				return false;
			}
		}
		return true;
	}
}
