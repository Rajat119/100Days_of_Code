class Solution {
    private int timestamp;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        /* Build Graph */
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++)
            graph.put(i, new ArrayList<Integer>());
        
        for (List<Integer> edge: connections){
            int v0 = edge.get(0);
            int v1 = edge.get(1);
            graph.get(v0).add(v1);
            graph.get(v1).add(v0);
        }
        
        int[] parent = new int[n];
        int[] low = new int[n];
        int[] disc = new int[n];
        for (int i=0; i<n; i++)
            parent[i] = i;
        
        boolean[] visited = new boolean[n];
        
        List<List<Integer>> res = new ArrayList<>();

        this.timestamp = 0;
        
        DFS(0, graph, visited, parent, low, disc, res);
                
        return res;
    }
    
    private void DFS(int i, Map<Integer, List<Integer>> graph, boolean[] visited, int[] parent, int[] low, int[] disc, List<List<Integer>> res) {
        visited[i] = true;
        low[i] = timestamp;
        disc[i] = timestamp;
        timestamp++;
        
        for (int j: graph.get(i)) {
            if (!visited[j]) {
                parent[j] = i;
                
                DFS(j, graph, visited, parent, low, disc, res);
                
                low[i] = Math.min(low[j], low[i]);
                if (disc[i] < low[j]) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(i);
                    sol.add(j);
                    res.add(sol);
                }
            } else {
                if (j != parent[i]) {
                    low[i] = Math.min(low[i], disc[j]);
                }
            }
        }
    }
}