import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/game-of-thrones
public class GameOfThronesI {

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        String a2 = input.nextLine();
        int length = a2.length();
        int[] freqDist = new int[500];
        for(int a = 0; a < length; a++){
            freqDist[a2.charAt(a)]++;
        }
        int oddCount = 0;
        for(int a = 0; a < freqDist.length; a++){
            if(freqDist[a]%2==1){
                oddCount++;
            }
        }
        if((length%2 == 0 && oddCount == 0) || (length%2==1 && oddCount == 1)){
            System.out.println("YES");
        }
        else{
           System.out.println("NO");
        }
    }
}