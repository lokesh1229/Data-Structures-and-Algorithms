import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphStoring2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of vertices
        int m = sc.nextInt(); // Number of edges

        List<List<Integer>> adj = new ArrayList<>(n + 1);
        // 1- indexed
        // 0 - indexed List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // For undirected graph
            adj.get(u).add(v);
            adj.get(v).add(u);

            // For directed graph, use only:
            // adj.get(u).add(v);
        }


        // printGraph(adj, n);
        System.out.println(bfs(adj, n));
        sc.close();
    }

    public static void printGraph(List<List<Integer>> adj, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("Node " + i + ": ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> bfs(List<List<Integer>> adj, int V){
        List<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V+1];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(1);
        // For 0-indexed --> q.add(0);
        vis[1] = true;
        //For 1-indexed --> vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for(Integer i: adj.get(node)){
                if(vis[i] == false){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        
        return bfs;
    }
}
