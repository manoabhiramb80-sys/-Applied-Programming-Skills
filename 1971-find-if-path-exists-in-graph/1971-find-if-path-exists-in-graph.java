class Solution {
    int[] parent;
    int[] rank;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];

        // Initialize each node to be its own parent
        for (int i = 0; i < n; i++) parent[i] = i;

        // Union connected nodes
        for (int i = 0; i < edges.length; i++) {
            int n1 = find(edges[i][0]);
            int n2 = find(edges[i][1]);

            if (n1 == n2) continue;

            if (rank[n1] == rank[n2]) {
                parent[n2] = n1;
                rank[n1]++;
            } else if (rank[n1] > rank[n2]) {
                parent[n2] = n1;
            } else {
                parent[n1] = n2;
            }
        }

        // Check if source and destination are connected
        return find(source) == find(destination);
    }

    public int find(int n) {
        if (parent[n] != n)
            parent[n] = find(parent[n]); // Path compression
        return parent[n];
    }
}