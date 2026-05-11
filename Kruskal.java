import java.util.*;

class Edge implements Comparable<Edge>{
    int s,d,w;
    public int compareTo(Edge e){
        return this.w-e.w;
    }
}

public class Kruskal {
    static int parent[];

    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }

    static void union(int a,int b){
        parent[find(a)]=find(b);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter vertices and edges: ");
        int v=sc.nextInt(), e=sc.nextInt();

        Edge edges[]=new Edge[e];

        for(int i=0;i<e;i++){
            edges[i]=new Edge();
            System.out.println("Enter src dest weight:");
            edges[i].s=sc.nextInt();
            edges[i].d=sc.nextInt();
            edges[i].w=sc.nextInt();
        }

        Arrays.sort(edges);

        parent=new int[v];
        for(int i=0;i<v;i++) parent[i]=i;

        int cost=0;

        for(Edge ed:edges){
            if(find(ed.s)!=find(ed.d)){
                System.out.println(ed.s+"-"+ed.d+"="+ed.w);
                cost+=ed.w;
                union(ed.s,ed.d);
            }
        }

        System.out.println("Total cost="+cost);
    }
}

/*
Sample Output
Enter vertices and edges: 3 3
0 1 1
1 2 2
0 2 3
0-1=1
1-2=2
Total cost=3
*/