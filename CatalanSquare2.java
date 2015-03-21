import java.util.Scanner;
import java.math.BigInteger;
 
 
public class CatalanSquare2 {
    public static void main(String[] args){
                Scanner input = new Scanner(System.in);
                int inputNumber = input.nextInt();
                BigInteger sum = new BigInteger("0");
                for(int a = 0; a <= inputNumber; a++){
                        sum = sum.add((compute(a).multiply(compute(inputNumber-a))));
                }
                if(sum.toString() != "0"){
                System.out.println(sum);
                }
                else System.out.println("1");
        }
        public static BigInteger compute(int a){
                
                BigInteger temp = fact(a);
                if(a == 1 || a == 0){
                        return new BigInteger("1");
                }
                BigInteger answer = ((fact(2*a).divide(temp)).divide(temp)).divide(new BigInteger("" + (a + 1)));
                return answer;
        }
        public static BigInteger fact(int a){
                BigInteger product = new BigInteger("1");
                for(int b = a; b >= 1; b--){
                        product = product.multiply(new BigInteger("" + b));
                }
                return product;
        }
}

