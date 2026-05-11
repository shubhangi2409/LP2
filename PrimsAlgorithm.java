import java.util.*;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

      
        System.out.println("Enter adjacency matrix:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean selected[] = new boolean[n];
        selected[0] = true; // start from vertex 0

        int edges = 0;
        int totalCost = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        while(edges < n - 1) {
            int min = Integer.MAX_VALUE;
            int x = 0, y = 0;

            for(int i = 0; i < n; i++) {
                if(selected[i]) {
                    for(int j = 0; j < n; j++) {
                        if(!selected[j] && graph[i][j] != 0) {
                            if(graph[i][j] < min) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

           
            System.out.println(x + " - " + y + " : " + graph[x][y]);

            totalCost += graph[x][y];
            selected[y] = true;
            edges++;
        }

        System.out.println("Total cost of MST: " + totalCost);
    }
}

/*
Sample Input
Enter number of vertices: 4
Enter adjacency matrix:
0 10 6 5
10 0 0 15
6 0 0 4
5 15 4 0
Sample Output
Edges in Minimum Spanning Tree:
0 - 3 : 5
3 - 2 : 4
0 - 1 : 10
Total cost of MST: 19

*/