import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/sparse-arrays
public class SparseArrays {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int a =0; a < n; a++){
            String i = input.next();
            if(!map.containsKey(i)){
                map.put(i, 0);
            }
            map.put(i, map.get(i)+1);
        }
        int k = input.nextInt();
        for(int b = 0; b < k; b++){
            String query = input.next();
            if(!map.containsKey(query)){
                map.put(query, 0);
            }
            System.out.println(map.get(query));
        }
    }
}