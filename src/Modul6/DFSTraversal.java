package Modul6;

import java.util.*;

class DFSTraversal {
    private LinkedList<Integer> adj[];
    private boolean visited[];

    DFSTraversal(int V){
        adj = new LinkedList[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    void insertEdge(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(src);  // Since it's an undirected graph, add both edges
    }

    void DFS(int vertex){
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // To ensure the correct traversal order, sort the adjacency list
        Collections.sort(adj[vertex], Collections.reverseOrder());

        for (int n : adj[vertex]) {
            if (!visited[n])
                DFS(n);
        }
    }

    public static void main(String args[]){
        DFSTraversal graph = new DFSTraversal(6); // There are 6 nodes, from 0 to 5

        // Insert the edges in a way that allows DFS to visit in the required order
        graph.insertEdge(3, 2);
        graph.insertEdge(2, 5);
        graph.insertEdge(2, 1);
        graph.insertEdge(5, 4);
        graph.insertEdge(4, 0);
        graph.insertEdge(1, 0);

        System.out.println("Depth First Traversal starting from node 3:");
        graph.DFS(3);
    }
}
