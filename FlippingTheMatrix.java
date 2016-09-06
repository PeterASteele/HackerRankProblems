import java.io.*;
import java.util.*;
//World CodeSpring 6, problem 3
//https://www.hackerrank.com/contests/world-codesprint-6/challenges/flipping-the-matrix
public class FlippingTheMatrix {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int q = input.nextInt();
		for(int a = 0; a < q; a++){
			int n = input.nextInt();
			int[][] arr = new int[2*n][2*n];
			for(int b = 0; b < 2*n; b++){
				for(int c =0 ; c < 2*n; c++){
					arr[b][c] = input.nextInt();
				}
			}
			long sum = 0;
			for(int b = 0; b < n; b++){
				for(int c = 0; c < n; c++){
					sum += Math.max(Math.max(arr[b][c], arr[2*n-b-1][c]), Math.max(arr[b][2*n-c-1], arr[2*n-b-1][2*n-c-1]));
				}
			}
			System.out.println(sum);
		}
	}

}