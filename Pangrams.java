import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/pangrams
public class Pangrams {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        int[] freqDist = new int[26];
        for(int a = 0; a < in.length(); a++){
            String sub = in.substring(a, a+1);
            sub = sub.toLowerCase();
            if(!sub.equals(" ")){
                freqDist[sub.charAt(0)-'a']++;
            }
        }
        boolean panagram = true;
        for(int a = 0; a < freqDist.length;a++){
            if(freqDist[a] == 0){
                panagram = false;
            }
        }
        if(panagram){
            System.out.println("pangram");
        }
        else{
            System.out.println("not pangram");
        }
    }
}