import java.util.*;

public class AStar {

    // Node class inside main class
    static class Node implements Comparable<Node> {

        int v, g, h, f;

        Node(int v, int g, int h) {
            this.v = v;
            this.g = g;
            this.h = h;
            this.f = g + h;
        }

        // Compare nodes based on f value
        public int compareTo(Node n) {
            return this.f - n.f;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.println("Enter edges:");

        for (int i = 0; i < e; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
        }

        int h[] = new int[n];

        System.out.println("Enter heuristic values:");

        for (int i = 0; i < n; i++)
            h[i] = sc.nextInt();

        System.out.print("Enter start node: ");
        int start = sc.nextInt();

        System.out.print("Enter goal node: ");
        int goal = sc.nextInt();

        // Priority Queue
        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean visited[] = new boolean[n];

        int parent[] = new int[n];

        Arrays.fill(parent, -1);

        pq.add(new Node(start, 0, h[start]));

        // A* Search
        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            if (curr.v == goal)
                break;

            visited[curr.v] = true;

            if (graph.containsKey(curr.v)) {

                for (int next : graph.get(curr.v)) {

                    if (!visited[next]) {

                        pq.add(
                                new Node(
                                        next,
                                        curr.g + 1,
                                        h[next]));

                        parent[next] = curr.v;
                    }
                }
            }
        }

        // Path reconstruction
        List<Integer> path = new ArrayList<>();

        for (int i = goal; i != -1; i = parent[i])
            path.add(i);

        Collections.reverse(path);

        // Output
        System.out.println("\nGoal reached: " + goal);

        System.out.print("Path: ");

        for (int x : path)
            System.out.print(x + " ");

        sc.close();
    }
}


/*
Enter number of vertices: 5
Enter number of edges: 4
Enter edges:
0 1
0 2
1 3
1 4
Enter heuristic values:
0
1
2
3
4
Enter start node: 0
Enter goal node: 4

Goal reached: 4
Path: 0 1 4 */