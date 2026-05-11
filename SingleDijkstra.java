import java.util.*;

public class SingleDijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                graph[i][j]=sc.nextInt();

        System.out.print("Enter source: ");
        int src=sc.nextInt();

        int dist[]=new int[n];
        boolean vis[]=new boolean[n];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        for(int i=0;i<n-1;i++){
            int u=-1,min=Integer.MAX_VALUE;

            for(int j=0;j<n;j++){
                if(!vis[j] && dist[j]<min){
                    min=dist[j];
                    u=j;
                }
            }

            vis[u]=true;

            for(int v=0;v<n;v++){
                if(graph[u][v]!=0 && !vis[v] &&
                   dist[u]+graph[u][v]<dist[v]){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }

        for(int i=0;i<n;i++)
            System.out.println(src+"->"+i+"="+dist[i]);
    }
}
/*

Sample Output
Enter vertices: 3
Enter adjacency matrix:
0 1 4
1 0 2
4 2 0
Enter source: 0
0->0=0
0->1=1
0->2=3
*/