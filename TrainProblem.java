import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TrainProblem {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int capacity = stdin.nextInt();
		int numberOfStops = stdin.nextInt();
		int[][] stops = new int[numberOfStops][3];
		for(int a = 0; a < numberOfStops; a++){
			stops[a][0] = stdin.nextInt(); //people who leave train.
			stops[a][1] = stdin.nextInt(); //people who get on train
			stops[a][2] = stdin.nextInt(); //left on platform
		}
		System.out.println(trainSim(stops, capacity));
	}
	public static String trainSim(int [][] data, int capacity){
		int currentLoad = 0;
		int stop = 0;
		while(stop != data.length){
			if(data[stop][0] > currentLoad){
				return "impossible"; //more people get off than currently exist on train
			}
			if(currentLoad - data[stop][0] + data[stop][1] > capacity){
				return "impossible"; //there are more people on the train than the capacity of the train
			}
			if(currentLoad - data[stop][0] + data[stop][1] < capacity && data[stop][2] != 0){
				return "impossible"; //there was room on the train and they did not get on.
			}
			currentLoad = currentLoad - data[stop][0] + data[stop][1];
			stop++;
		}
		if(currentLoad != 0){
			return "impossible";
		}
		return "possible";
	}
}
