import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
This problem is a programming version of Problem 1 from projecteuler.net

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below N.

Input Format 
First line contains T that denotes the number of test cases. This is followed by T lines, each containing an integer, N.

Output Format 
For each test case, print an integer that denotes the sum of all the multiples of 3 or 5 below N.

Constraints 
1≤T≤105 
1≤N≤109
*/

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin = new Scanner(System.in);
        // The first integer is the number of cases to be evaluated.
        int numberOfCases = Integer.parseInt(stdin.nextLine());
        // Set initial values
        BigInteger sum = new BigInteger("0");
        int caseTemp = 0;
        BigInteger temp = null;
        //Loop through the number of given cases
        for(int a = 0; a < numberOfCases; a++){
            caseTemp = Integer.parseInt(stdin.nextLine()) - 1;
            BigInteger caseTemp2 = new BigInteger("" + caseTemp);
            //Set sum of the a'th case to zero
            sum = new BigInteger("0");
            
            //Calculate the number of multiples of 3 under the value given.
            temp = caseTemp2.divide(new BigInteger("3"));
            
            //Sum these multiples using n*(n+1)/2*3 where n is the number of multiples, and add this to the current sum.
            sum = sum.add(temp.multiply(temp.add(new BigInteger("1"))).divide(new BigInteger("2")).multiply(new BigInteger("3")));
            
            //Calculate the number of multiples of 5 under the value given.
            temp = caseTemp2.divide(new BigInteger("5"));
            
            //Sum these multiples using n*(n+1)/2*5 where n is the number of multiples, and add this to the current sum.
            sum = sum.add(temp.multiply(temp.add(new BigInteger("1"))).divide(new BigInteger("2")).multiply(new BigInteger("5")));
            
            //At this point, we've solved for each value, but we've double counted multiples of 3 and 5. In order to fix this, we will subtract the sum of all of the multiples of 15 under n.
            //Calculate the number of multiples of 15 under the value given.
            temp = caseTemp2.divide(new BigInteger("15"));
            
            //Sum these multiples using n*(n+1)/2*15 where n is the number of multiples, and subtract this from the current sum.
            sum = sum.subtract(temp.multiply(temp.add(new BigInteger("1"))).divide(new BigInteger("2")).multiply(new BigInteger("15")));
            
            //Print out answer for the given case.
            System.out.println(sum);
        }
  
    }
}
