import java.util.*;

// Using Adj matrix
class GraphStoring1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int adj[][] = new int[n+1][m+1];
        for (int i = 0; i < m; i++) {
            int u,v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
    }
}