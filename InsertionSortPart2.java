import java.util.Scanner;

public class InsertionSortPart2 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int lengthOfList = Integer.parseInt(stdin.nextLine());
		int[] input = new int[lengthOfList];
		for (int a = 0; a < lengthOfList; a++) {
			input[a] = stdin.nextInt();
		}
		if (lengthOfList > 1){
			int b = 2;
			while(b <= lengthOfList){
				input = merge(insertionSort(subarray(input, 0, b), b), subarray(input, b, lengthOfList)); 
				printArray(input);
				b++;
			}
		}
		else{
			System.out.println(input[0]);
		}
		
		
	}
	public static void printArray(int[] input){
		for(int b = 0; b < input.length; b++){
			System.out.print(input[b] + " "); 
		}
		System.out.println();
	}
	public static int[] insertionSort(int[] input, int lengthOfList) {
		int temp = input[lengthOfList - 1];
		int a = lengthOfList - 2;
		while (a > -1 && a < lengthOfList && temp < input[a]) { // while
																// position has
																// not been
																// found, we
			input[a + 1] = input[a]; // shift the elements over
			a--; // iterate the variable.
		}
		input[a + 1] = temp;
		return input;
	}
	public static int[] subarray(int[] array, int start, int end){ //includes start but not end
		int [] output = new int[end-start];
		for(int a = 0; a < output.length; a++){
			output[a] = array[start + a];
		}
		return output;
	}
	public static int[] merge(int[] array, int[] array2){
		int length = array.length + array2.length;
		int ret[] = new int[length];
		for(int a = 0; a < array.length; a++){
			ret[a] = array[a];
		}
		for(int b = 0; b < array2.length; b++){
			ret[array.length + b] = array2[b];
		}
		return ret;
	}
}
