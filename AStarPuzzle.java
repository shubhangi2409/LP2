import java.util.*;

class Node implements Comparable<Node> {

    int[][] board;
    int x, y;
    int cost;
    int level;
    Node parent;

    // Constructor
    Node(int[][] board, int x, int y,
         int level, Node parent) {

        this.board = new int[3][3];

        for (int i = 0; i < 3; i++) {
            this.board[i] = board[i].clone();
        }

        this.x = x;
        this.y = y;
        this.level = level;
        this.parent = parent;
    }

    // Heuristic Function
    int calculateCost(int[][] goal) {

        int count = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] != 0 &&
                        board[i][j] != goal[i][j]) {

                    count++;
                }
            }
        }

        return count;
    }

    // Total Cost Function
    int totalCost() {

        return cost + level;
    }

    // Compare Nodes for Priority Queue
    @Override
    public int compareTo(Node other) {

        return this.totalCost() - other.totalCost();
    }
}

public class AStarPuzzle {

    static int[] row = {1, 0, -1, 0};
    static int[] col = {0, -1, 0, 1};

    // Print Puzzle Board
    static void printBoard(int[][] board) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Print Solution Path
    static void printPath(Node root) {

        if (root == null)
            return;

        printPath(root.parent);

        printBoard(root.board);

        System.out.println();
    }

    // Check Valid Position
    static boolean isSafe(int x, int y) {

        return (x >= 0 && x < 3 &&
                y >= 0 && y < 3);
    }

    // A* Algorithm
    static void solve(int[][] initial,
                      int x, int y,
                      int[][] goal) {

        PriorityQueue<Node> pq =
                new PriorityQueue<>();

        Node root =
                new Node(initial, x, y,
                        0, null);

        root.cost =
                root.calculateCost(goal);

        pq.add(root);

        while (!pq.isEmpty()) {

            Node min = pq.poll();

            // Goal State Found
            if (min.cost == 0) {

                System.out.println("\nSolution Found:\n");

                printPath(min);

                return;
            }

            // Generate Child Nodes
            for (int i = 0; i < 4; i++) {

                int newX = min.x + row[i];
                int newY = min.y + col[i];

                if (isSafe(newX, newY)) {

                    int[][] newBoard =
                            new int[3][3];

                    for (int r = 0; r < 3; r++) {

                        newBoard[r] =
                                min.board[r].clone();
                    }

                    // Swap Empty Tile
                    int temp =
                            newBoard[min.x][min.y];

                    newBoard[min.x][min.y] =
                            newBoard[newX][newY];

                    newBoard[newX][newY] = temp;

                    // Create Child Node
                    Node child =
                            new Node(newBoard,
                                    newX, newY,
                                    min.level + 1,
                                    min);

                    child.cost =
                            child.calculateCost(goal);

                    pq.add(child);
                }
            }
        }

        System.out.println("No Solution Found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] initial = new int[3][3];
        int[][] goal = new int[3][3];

        int x = 0, y = 0;

        // Input Initial State
        System.out.println("Enter Initial Puzzle State:");
        System.out.println("Use 0 for empty space\n");

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                initial[i][j] = sc.nextInt();

                // Find Empty Tile Position
                if (initial[i][j] == 0) {

                    x = i;
                    y = j;
                }
            }
        }

        // Input Goal State
        System.out.println("\nEnter Goal Puzzle State:");

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                goal[i][j] = sc.nextInt();
            }
        }

        // Display Initial State
        System.out.println("\nInitial State:\n");
        printBoard(initial);

        // Display Goal State
        System.out.println("\nGoal State:\n");
        printBoard(goal);

        // Solve Puzzle
        solve(initial, x, y, goal);

        sc.close();
    }
}