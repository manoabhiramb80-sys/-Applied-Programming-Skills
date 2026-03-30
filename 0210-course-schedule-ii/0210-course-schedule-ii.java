class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        // build graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }

        HashSet<Integer> visiting = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            // non visited nodes
            if (!visited.contains(i)) {
                if (dfs(i, graph, visiting, visited, stack) == true) {
                    return new int[0]; // cycle found
                }
            }
        }

        // order of courses - parent first and children later - topological sort
        int[] result = new int[numCourses];
        int i = 0;

        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        return result;
    }

    public boolean dfs(
            int node,
            HashMap<Integer, List<Integer>> graph,
            HashSet<Integer> visiting,
            HashSet<Integer> visited,
            Stack<Integer> stack) {

        // course done - return
        if (visited.contains(node))
            return false;

        // if in recursion - return
        if (visiting.contains(node))
            return true; // cycle found

        // if not - add to recursion
        visiting.add(node);

        // look out for neighbors
        for (int neighbor : graph.get(node)) {
            // if true then node already in recursion 
            if (dfs(neighbor, graph, visiting, visited, stack) == true) {
                return true;  // cycle found
            }
        }

        // remove from recursion
        visiting.remove(node);

        // add to visited - course done
        visited.add(node);

        // to get topological sort
        stack.push(node);

        return false;
    }
}