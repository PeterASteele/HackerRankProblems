import java.util.Scanner;

public class WeeklyChallenges_Week13_ASuperHero {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 */
		Scanner stdin = new Scanner(System.in);
		// Parses the number of cases
		int numberOfCases = Integer.parseInt(stdin.nextLine());
		int numberOfLevels = 0;
		int enemiesPerLevel = 0;
		int[][] power = null;
		int[][] bullets = null;
		int[] bulletsNeededArray = null;
		int bulletsNecessary = 0;
		int bulletsNecessaryTemp = 0;
		int[] bestEnemyPath = null;
		for (int a = 0; a < numberOfCases; a++) {
			numberOfLevels = stdin.nextInt();
			enemiesPerLevel = stdin.nextInt();
			stdin.nextLine();
			power = new int[numberOfLevels][enemiesPerLevel];
			bullets = new int[numberOfLevels][enemiesPerLevel];
			// Create 2d arrays for power and bullets and parse input data
			// accordingly.
			for (int c = 0; c < numberOfLevels; c++) {
				for (int b = 0; b < enemiesPerLevel; b++) {
					power[c][b] = stdin.nextInt();
				}
				stdin.nextLine();
			}
			for (int c = 0; c < numberOfLevels; c++) {
				for (int b = 0; b < enemiesPerLevel; b++) {
					bullets[c][b] = stdin.nextInt();
				}
				if (a < numberOfCases - 1 && c < numberOfLevels-1) {
					stdin.nextLine();
				}
			}
			bulletsNecessaryTemp = integerArrayMin(power[numberOfLevels - 1]);
			bulletsNecessary = 0;
			bulletsNeededArray = new int[enemiesPerLevel];
			for (int c = 0; c < enemiesPerLevel; c++) {
				bulletsNeededArray[c] = bulletsNecessaryTemp;
			}
			bestEnemyPath = new int[numberOfLevels];
			bestEnemyPath[numberOfLevels -1 ] = integerArrayMinIndex(power[numberOfLevels-1]);
			for (int c = numberOfLevels - 2; c >= 0; c--) {
				for (int d = 0; d < enemiesPerLevel; d++) {
					bulletsNeededArray[d] =	bulletsNecessaryTemp + power[c][d] - (Math.min(bulletsNecessaryTemp, bullets[c][d]));
				}
				bestEnemyPath[c] = integerArrayMinIndex(bulletsNeededArray);
				bulletsNecessaryTemp = power[c][integerArrayMinIndex(bulletsNeededArray)];				
			}
			int sum = 0;
			int bulletsTemp = 0;
			for(int c = 0; c < numberOfLevels; c++){
				System.out.print(bestEnemyPath[c]);
				sum += Math.max(power[c][bestEnemyPath[c]] - bulletsTemp, 0);
				bulletsTemp = bullets[c][bestEnemyPath[c]];
			}
			System.out.println();
			System.out.println(sum);
		}
	}

	public static int integerArrayMin(int input[]) {
		int min = Integer.MAX_VALUE;
		for (int a = 0; a < input.length; a++) {
			if (min > input[a])
				min = input[a];
		}
		return min;
	}
	public static int integerArrayMinIndex(int input[]) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int a = 0; a < input.length; a++) {
			if (min > input[a]){
				min = input[a];
				index = a;
			}
		}
		return index;
	}
}
