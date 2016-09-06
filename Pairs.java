import java.io.*;
import java.util.*;
import java.*;
//https://www.hackerrank.com/challenges/pairs
public class Pairs {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int goal = input.nextInt();
        HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        HashSet<Integer> noDuplicates = new HashSet<Integer>();
        for(int a = 0; a < n; a++){
            int temp = input.nextInt();
            noDuplicates.add(temp);
            if(mapping.containsKey(temp)){
                mapping.put(temp, mapping.get(temp)+1);
            }
            else{
                mapping.put(temp, 1);
            }
        }
        int[] newArr = new int[mapping.size()];
        long count = 0;
        for(Integer a:noDuplicates){
            if(mapping.containsKey(a+goal)){
                count+=mapping.get(a+goal)*mapping.get(a);
            }
        }
        System.out.println(count);
    }
}