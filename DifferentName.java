import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DifferentName {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numInputs = stdin.nextInt();
		int towers[] = new int[numInputs];
		for(int a = 0; a < numInputs; a++){
			towers[a] = stdin.nextInt();
		}
		ArrayList<Integer> possibilities = new ArrayList<Integer>();
		possibilities.add(numInputs); //case where you just zap each entire building
		Arrays.sort(towers);
		for(int a = 0; a < towers.length; a++){
			possibilities.add(towers[a] + (towers.length-a-1));
		}
		printMin(possibilities);
		
	}
	public static int maxTower(int[] towers){
		int max = 0;
		for(int a = 0; a < towers.length; a++){
			if(max < towers[a]){
				max = towers[a];
			}
		}
		return Math.min(max, 100000);
	}
	public static void printTowers(int[] towers){
		for(int a = 0; a < towers.length; a++){
			System.out.println(towers[a]);
		}
	}
	public static void printMin(ArrayList<Integer> input){
		int min = 2147000000;
		for(int a = 0; a < input.size(); a ++){
			if (min > input.get(a)){
				min = input.get(a);
			}
		}
		System.out.println(min);
	}
}
