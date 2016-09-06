import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.concurrent.*;
//https://www.hackerrank.com/challenges/bfsshortreach
public class BreadthFirstSearchShortestReach {
        
    public static void calculate_cost(Scanner sc){
        
        // build list
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[N];
        int[] dist = new int[N];
        for (int i = 0; i < M; i++) {
			int key = sc.nextInt() - 1;
			int rot = sc.nextInt() - 1;
			if (graph[key] == null) {
				graph[key] = new ArrayList<Integer>();
			}
			if (graph[rot] == null) {
				graph[rot] = new ArrayList<Integer>();
			}
			graph[key].add(rot);
			graph[rot].add(key);
		}
        int start = sc.nextInt();
        dist[start-1] = 5; // if 5 found later then it is know to be start
        
        
        // start traversal
        LinkedBlockingQueue todo = new LinkedBlockingQueue();
        LinkedBlockingQueue cost = new LinkedBlockingQueue();
        todo.offer(start-1);
        cost.offer(0);
        while(todo.size()!=0){
            int at = (int)todo.poll();
            int depth = (int)cost.poll();
            if (dist[at] == 0){
                dist[at] = 6 * depth;
                if (graph[at] != null){
                    for(int i = 0; i < graph[at].size(); i++){
                        todo.offer(graph[at].get(i));
                        cost.offer(depth+1);
                    }
                }
            } else if (dist[at] == 5){
                if (graph[at] != null){
                    for(int i = 0; i < graph[at].size(); i++){
                        todo.offer(graph[at].get(i));
                        cost.offer(depth+1);
                    }
                }
            }
        }
        
        for(int i = 0; i < dist.length; i++){
            if (dist[i] == 5){
                continue;
            } else if (dist[i] == 0){
                System.out.print("-1 ");
            } else {
                System.out.print(dist[i]+" ");
            }
        }
        System.out.println();
        
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            calculate_cost(sc);
        }
    }
}