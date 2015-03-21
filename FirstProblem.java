import java.util.Scanner;


public class FirstProblem {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numInputs = 4;;
		int inputEmma[] = new int[numInputs];
		int inputGunnar[] = new int[numInputs];
		for(int a = 0; a < numInputs; a++){
			inputGunnar[a] = stdin.nextInt();
		}
		for(int a = 0; a < numInputs; a++){
			inputEmma[a] = stdin.nextInt();
		}
		double EmmaE1 = (inputEmma[0] + inputEmma[1])/2.0;
		double EmmaE2 = (inputEmma[2] + inputEmma[3])/2.0;
		double GunnarE1 = (inputGunnar[0] + inputGunnar[1])/2.0;
		double GunnarE2 = (inputGunnar[2] + inputGunnar[3])/2.0;
		if(EmmaE1 + EmmaE2 == GunnarE1 + GunnarE2){
			System.out.println("Tie");
		}
		else if(EmmaE1 + EmmaE2 > GunnarE1 + GunnarE2){
			System.out.println("Emma");
		}
		else{
			System.out.println("Gunnar");
		}
	}

}
