import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/basic-cryptanalysis
public class BasicCryptanalysis {

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner input = new Scanner(new File("dictionary.lst"));
        ArrayList<String> dict = new ArrayList<String>();
        HashMap<ArrayList<Integer>, ArrayList<String>> dictionary = new HashMap<ArrayList<Integer>, ArrayList<String>>();
        while(input.hasNext()){
            String tmp = input.next();
            dict.add(tmp);
            ArrayList<Integer> freqDistOfFreqDist = getFreqDistOfFreqDist(tmp);
            if(!dictionary.containsKey(freqDistOfFreqDist)){
                dictionary.put(freqDistOfFreqDist, new ArrayList<String>());
            }
            dictionary.get(freqDistOfFreqDist).add(tmp);
        }
        
        input = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> otherMap = new ArrayList<String>();
        
        while(input.hasNext()){
            String temp = input.next();
            arr.add(temp);
            otherMap.add("~");
        }
        HashMap<Character, Character> knownCharacters = new HashMap<Character, Character>();
        
        for(int asdf = 0; asdf < 100; asdf++){
            for(int k = 0; k < arr.size(); k++){
                String temp = arr.get(k);
                ArrayList<Integer> freqDistOfFreqDist = getFreqDistOfFreqDist(temp);
                ArrayList<String> possibilities = new ArrayList<String>();
                if(dictionary.containsKey(freqDistOfFreqDist)){
                    for(String i:dictionary.get(freqDistOfFreqDist)){
                        //temp is a potential map with i
                        if(possibleMatch(temp, i, knownCharacters)){
                            possibilities.add(i);
                        }
                    }
                }
                if(asdf == 99 && possibilities.size() == 0){
                   String out = convert(temp, knownCharacters);
                   otherMap.set(k, out);
                }
                else if(possibilities.size() == 1 || asdf == 99){
                    otherMap.set(k, possibilities.get(0));
                    for(int a = 0; a < possibilities.get(0).length(); a++){
                        knownCharacters.put(temp.charAt(a), possibilities.get(0).charAt(a));
                    }
                }
            }
        }
        System.err.println(knownCharacters);
        for(String i: otherMap){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static boolean possibleMatch(String temp, String i, HashMap<Character, Character> knownCharacters){
        for(int a = 0; a < i.length(); a++){
            if(knownCharacters.containsKey(temp.charAt(a))){
                if(i.charAt(a) != knownCharacters.get(temp.charAt(a))){
                    return false;
                }
            }    
        }
        return true;
    }   
    public static String convert(String temp, HashMap<Character, Character> knownCharacters){
        StringBuilder output = new StringBuilder();
        for(int a = 0; a < temp.length(); a++){
            if(knownCharacters.containsKey(temp.charAt(a))){
                output.append(knownCharacters.get(temp.charAt(a)));
            }
            else{
                output.append(temp.charAt(a));
            }
        }
        return output.toString();
    }
    public static ArrayList<Integer> getFreqDistOfFreqDist(String tmp){
        int[] freqDist = new int[256];
        for(int a = 0; a < tmp.length(); a++){
            freqDist[tmp.charAt(a)]++;
        }
        int[] freqDistfreqDist = new int[tmp.length()+1];
        for(int a = 0; a < 256; a++){
            if(freqDist[a] != 0){
                freqDistfreqDist[freqDist[a]]++;
            }
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int a = 0; a < freqDistfreqDist.length; a++){
            ret.add(freqDistfreqDist[a]);
        }
        return ret;
    }
}