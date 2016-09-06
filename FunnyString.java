import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/funny-string
public class FunnyString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        for(int a = 0; a < n; a++){
            String n2 = input.nextLine();
            boolean ok = true;
            for(int b = 0; b < n2.length()-1; b++){
                if(Math.abs(n2.charAt(b)-n2.charAt(b+1))!=Math.abs(n2.charAt(n2.length()-1-b)-n2.charAt(n2.length()-1-b-1))){
                    ok = false;
                }
            }
            if(ok){
                System.out.println("Funny");
            }
            else{
                System.out.println("Not Funny");
            }
        }
    }
}