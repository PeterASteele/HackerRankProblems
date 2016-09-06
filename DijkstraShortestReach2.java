import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/challenges/dijkstrashortreach


// since we only care about min values for least costly 
// path then we can remove duplicate edges that are more costly

public class DijkstraShortestReach2 {
    
    public static int next(int[] dist, Boolean[] done){
        int smallest_cost = Integer.MAX_VALUE;
        int closest = -1;
        for (int i =0; i < dist.length; i++){
            if (!done[i] && dist[i] <= smallest_cost){
                smallest_cost = dist[i];
                closest = i;
            }
        }
        return closest;
    }
    
    public static void dj(int[][] g, Scanner in){
        int start = in.nextInt() -1;
        int num_v = g.length;
        int[] cost = new int[num_v];
        Boolean[] visited = new Boolean[num_v];
        
        for (int i = 0; i < num_v; i++){
            visited[i] = false;
            cost[i] = Integer.MAX_VALUE;
        }
        
        cost[start] = 0;
        
        for (int done = 0; done < num_v -1; done++){
            int nxt = next(cost, visited);
            visited[nxt] = true;
            
            for (int peer = 0; peer < num_v; peer++){
                if (!visited[peer] && g[nxt][peer] != 0 &&
                    cost[nxt] != (Integer.MAX_VALUE) &&
                   cost[nxt]+g[nxt][peer] < cost[peer]){
                    cost[peer] = cost[nxt]+g[nxt][peer];
                }
            }
        }
        
        for (int i = 0; i < num_v; i++){
            if (cost[i] != 0 && cost[i]!= (Integer.MAX_VALUE)){
                System.out.print(cost[i]+" ");
            } else if (cost[i] == (Integer.MAX_VALUE)){
                System.out.print("-1 ");
            }
        }
        System.out.println();
        
    }
    
        public static int[][] build_graph(Scanner in){
        int n = in.nextInt();
        int e = in.nextInt();
        int[][] g = new int[n][n];
        for(int i = 0; i < e; i++){
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int w = in.nextInt();
            if (g[x][y] == 0 || g[x][y] > w){
                g[x][y] = w;
                g[y][x] = w; 
            }
        }
        return g;
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){
            int[][] graph = build_graph(sc);
            dj(graph, sc);
        }
    }
}