import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Harrison
 * (Optimized by Peter)
 */
/*
 * To host a regional contest like NWERC a lot of preparation is necessary: organizing rooms and computers, making a good problem set, inviting contestants, designing T-shirts, booking hotel rooms and so on. I am responsible for going shopping in the supermarket.
When I get to the cash register, I put all my n items on the conveyor belt and wait until all the other customers in the queue in front of me are served. While waiting, I realize that this supermarket recently started to round the total price of a purchase to the nearest multiple of 10 cents (with 5 cents being rounded upwards). For example, 94 cents are rounded to 90 cents, while 95 are rounded to 100.

It is possible to divide my purchase into groups and to pay for the parts separately. I managed to find d dividers to divide my purchase in up to d+1 groups. I wonder where to place the dividers to minimize the total cost of my purchase. As I am running out of time, I do not want to rearrange items on the belt.

Input
The input consists of:

one line with two integers n (1≤n≤2000) and d (1≤d≤20), the number of items and the number of available dividers;
one line with n integers p1,…pn (1≤pi≤10000 for 1≤i≤n), the prices of the items in cents. The prices are given in the same order as the items appear on the belt.
Output
Output the minimum amount of money needed to buy all the items, using up to d dividers.

Sample Input 1	Sample Output 1
5 1
13 21 55 60 42
190
Sample Input 2	Sample Output 2
5 2
1 1 1 1 1
0
 */
public class CentSavings {
    
    public static int[] items;
    public static HashMap<String, Integer> cache = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), d = in.nextInt();
        items = new int[n];
        
        for (int i = 0; i < n; i++)
            items[i] = in.nextInt();
        
        System.out.println(dp(1, d, 0, 0));
    }
    
    public static int dp(int index, int dLeft, int cost, int dLast) {
        String key = index + " " + dLeft + " " + cost + " " + dLast;
        if (cache.containsKey(key)) return cache.get(key);
        if (index == items.length) return cost + calculate(dLast, index);
        
        int dCost = Integer.MAX_VALUE;
        if (dLeft > 0)
            dCost = cost + dp(index + 1, dLeft - 1, cost + calculate(dLast, index), index);
        
        int ndCost = cost + dp(index + 1, dLeft, cost, dLast);
        int temp = Math.min(dCost, ndCost);
        cache.put(key, Math.min(dCost, ndCost));
        
        return temp;
    }
    
    public static int calculate(int a, int b) {
        int sum = 0;
        for (int i = a; i < b; i++)
            sum += items[i];
        return round(sum);
    }
    
    public static int round(int n) {
        return (int)(Math.round((double)n / 10.0) * 10);
    }
}