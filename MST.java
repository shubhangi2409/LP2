import java.util.*;

public class MST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices: ");
        int n = sc.nextInt();

        int graph[][] = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                graph[i][j]=sc.nextInt();

        boolean selected[] = new boolean[n];
        selected[0]=true;

        int edges=0,total=0;

        while(edges<n-1){
            int min=Integer.MAX_VALUE,x=0,y=0;

            for(int i=0;i<n;i++){
                if(selected[i]){
                    for(int j=0;j<n;j++){
                        if(!selected[j] && graph[i][j]!=0){
                            if(graph[i][j]<min){
                                min=graph[i][j];
                                x=i; y=j;
                            }
                        }
                    }
                }
            }

            System.out.println(x+"-"+y+" : "+graph[x][y]);
            total+=graph[x][y];
            selected[y]=true;
            edges++;
        }

        System.out.println("Total Cost: "+total);
    }
}
/*
Sample Output
Enter vertices: 4
Enter adjacency matrix:
0 10 6 5
10 0 0 15
6 0 0 4
5 15 4 0
0-3 : 5
3-2 : 4
0-1 : 10
Total Cost: 19
*/