import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Depth-First Search (DFS) on a Graph
 * Given an undirected graph represented as an adjacency list and a
 * starting vertex, traverse the graph in DFS order and return the
 * list of visited vertices.
 *
 * Example (0-indexed, 5 vertices):
 *   Edges: 0-1, 0-2, 1-3, 2-4
 *   Start: 0
 *   DFS order: [0, 1, 3, 2, 4]  (depends on adjacency list order)
 *
 * Approach: Recursive DFS + visited array — O(V + E) time, O(V) space
 */
public class DFS {

    private final int vertices;
    private final List<List<Integer>> adjList;

    public DFS(int vertices) {
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

    public List<Integer> dfs(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> order = new ArrayList<>();
        dfsHelper(start, visited, order);
        return order;
    }

    private void dfsHelper(int node, boolean[] visited, List<Integer> order) {
        visited[node] = true;
        order.add(node);
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited, order);
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("DFS from 0: " + graph.dfs(0)); // Expected: [0, 1, 3, 5, 2, 4]
        System.out.println("DFS from 2: " + graph.dfs(2)); // Expected: [2, 0, 1, 3, 5, 4]
    }
}
