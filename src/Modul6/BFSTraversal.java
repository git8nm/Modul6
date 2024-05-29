package Modul6;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private int node;
    private LinkedList<Integer> adj[];
    private Queue<Integer> que;

    BFSTraversal(int v) {
        node = v;
        adj = new LinkedList[node];

        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        que = new LinkedList<Integer>();
    }

    void insertEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int n) {
        boolean nodes[] = new boolean[node];
        nodes[n] = true;
        que.add(n);

        while(!que.isEmpty()) {
            n = que.poll();
            System.out.print(n + " "); // Changed println to print to match the required output format

            for(int a : adj[n]) {
                if(!nodes[a]) {
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFSTraversal graph = new BFSTraversal(6);

        // Insert the edges as per the requirement
        graph.insertEdge(3, 2);
        graph.insertEdge(2, 1);
        graph.insertEdge(2, 4);
        graph.insertEdge(1, 5);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 0);
        graph.insertEdge(5, 0);
        graph.insertEdge(1, 0);

        System.out.println("traversal: ");
        graph.BFS(3); // Starting node
    }
}
