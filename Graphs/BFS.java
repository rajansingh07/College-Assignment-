import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Breadth-First Search (BFS) on a Graph
 * Given an undirected graph represented as an adjacency list and a
 * starting vertex, traverse the graph in BFS order and return the
 * list of visited vertices.
 *
 * Example (0-indexed, 5 vertices):
 *   Edges: 0-1, 0-2, 1-3, 2-4
 *   Start: 0
 *   BFS order: [0, 1, 2, 3, 4]
 *
 * Approach: Queue + visited array — O(V + E) time, O(V) space
 */
public class BFS {

    private final int vertices;
    private final List<List<Integer>> adjList;

    public BFS(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // undirected
    }

    public List<Integer> bfs(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return order;
    }

    public static void main(String[] args) {
        BFS graph = new BFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("BFS from 0: " + graph.bfs(0)); // Expected: [0, 1, 2, 3, 4, 5]
        System.out.println("BFS from 2: " + graph.bfs(2)); // Expected: [2, 0, 4, 1, 3, 5]
    }
}
