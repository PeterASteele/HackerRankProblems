import java.util.HashMap;
import java.util.Scanner;
import java.math.BigInteger;


public class CatalanSquare {
	static BigInteger[] factorialstorage;
	static BigInteger[] factorialstorage2;
	static BigInteger[] computestorage;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		factorialstorage = new BigInteger[5001];
		computestorage = new BigInteger[5001];
		factorialstorage2 = new BigInteger[5001];
		factorialstorage = factTemp(5001);
		factorialstorage2 = factTemp2(5001);
		computestorage = computeStore();
		
		int inputNumber = input.nextInt();
		BigInteger sum2 = new BigInteger("0");
		for(int a = 0; a <= inputNumber/2; a++){			
			sum2 = sum2.add(computestorage[a].multiply(computestorage[inputNumber-a]));
		}
		sum2 = sum2.multiply(new BigInteger("2"));
		if(inputNumber%2 == 0){
			sum2 = sum2.subtract((computestorage[inputNumber/2].pow(2)));
		}
		if(inputNumber != 0){
			System.out.println(sum2);
		}
		else System.out.println("1");
	}
	public static BigInteger compute(int a){
		if(a == 1 || a == 0){
			return new BigInteger("1");
		}
		//System.out.println("Computing " + a);
		BigInteger answer = ((factorialstorage2[a]).divide(factorialstorage[a])).divide(new BigInteger("" + (a+1)));
		return answer;
	}
	public static BigInteger[] computeStore(){
		BigInteger[] computeStore = new BigInteger[5001];
		for(int b = 0; b < 5001; b++){
			computeStore[b] = compute(b);
		}
		return computeStore;
	}
	public static BigInteger fact(int a){
		BigInteger product = new BigInteger("1");
		for(int b = 1; b <= a; b++){
			product = product.multiply(new BigInteger("" + b));
		}
		return product;
	}
	public static BigInteger[] factTemp(int a){
		BigInteger[] output = new BigInteger[a];
		output[0] = new BigInteger("1");
		BigInteger temp = new BigInteger("1");
		for(int b = 1; b < 5001; b++){
			temp = temp.multiply(new BigInteger("" + b));
			output[b] = temp;
		}
		return output;
	}
	public static BigInteger[] factTemp2(int a){
		BigInteger[] output = new BigInteger[a];
		output[0] = new BigInteger("1");
		BigInteger temp = new BigInteger("1");
		for(int b = 1; b < a; b++){
			temp = temp.multiply(new BigInteger("" + (2 * b) * (2 * b - 1)));
			temp = temp.divide(new BigInteger("" + b));
			output[b] = temp;
		}
		return output;
	}
	
}

