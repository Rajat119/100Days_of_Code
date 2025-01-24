class Solution {
    private boolean findCycle(int index, int[] visited, int[][] graph) {
        //this node is confirmed not to be part of a cycle
        if (visited[index] == 2) {
            return false;
        }
        //found an in process node (cycle)
        if (visited[index] == 1) {
            return true;
        }
        
        //mark node as in progress and explore neighbors (DFS)
        visited[index] = 1;
        for (int neighbor : graph[index]) {
            if (findCycle(neighbor, visited, graph)) {
                return true;
            }
        }

        //visited all neighbors and not found a cycle
        visited[index] = 2;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        /*
        Track the nodes.
        0 - not visited
        1 - in process
        2 - fully processed
        */
        int[] visited = new int[graph.length];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!findCycle(i, visited, graph)) {
                result.add(i);
            }
        }
        return result;
    }
}