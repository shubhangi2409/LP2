import java.util.*;

class Graph {

    private int vertices;
    private ArrayList<ArrayList<Integer>> adjList;

    // Constructor
    Graph(int v) {

        vertices = v;

        adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add Edge
    void addEdge(int v, int w) {

        adjList.get(v).add(w);
        adjList.get(w).add(v); // Undirected graph
    }

    // DFS Traversal
    void DFS(int start) {

        boolean[] visited = new boolean[vertices];

        System.out.print("DFS Traversal: ");

        dfsRecursive(start, visited);

        System.out.println();
    }

    private void dfsRecursive(int vertex, boolean[] visited) {

        visited[vertex] = true;

        System.out.print((char)(vertex + 'A') + " ");

        for (int neighbor : adjList.get(vertex)) {

            if (!visited[neighbor]) {

                dfsRecursive(neighbor, visited);
            }
        }
    }

    // BFS Traversal
    void BFS(int start) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;

        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int vertex = queue.poll();

            System.out.print((char)(vertex + 'A') + " ");

            for (int neighbor : adjList.get(vertex)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }
}

public class GraphTraversal {

    // Convert character to index
    static int charToIndex(char ch) {

        return ch - 'A';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");

        int v = sc.nextInt();

        Graph g = new Graph(v);

        System.out.print("Enter number of edges: ");

        int e = sc.nextInt();

        System.out.println("Enter edges using characters (Example: A B)");

        for (int i = 0; i < e; i++) {

            char c1 = sc.next().toUpperCase().charAt(0);

            char c2 = sc.next().toUpperCase().charAt(0);

            int v1 = charToIndex(c1);

            int v2 = charToIndex(c2);

            g.addEdge(v1, v2);
        }

        System.out.print("Enter starting vertex: ");

        char startChar = sc.next().toUpperCase().charAt(0);

        int start = charToIndex(startChar);

        g.DFS(start);

        g.BFS(start);

        sc.close();
    }
}