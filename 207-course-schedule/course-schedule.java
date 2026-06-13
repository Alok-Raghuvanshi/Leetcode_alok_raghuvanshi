class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       HashMap<Integer,List<Integer>>map=new HashMap<>();
       HashSet<Integer>set=new HashSet<>();
       int r=prerequisites.length;
       for(int i=0;i<r;i++)
       {
            if(!map.containsKey(prerequisites[i][0]))
            {
                List<Integer>l=new ArrayList<>();
                l.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],l);
            }
            else
            {
                List<Integer>l=map.get(prerequisites[i][0]);
                l.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],l);
            }
        }
        Set<Integer> visited = new HashSet<>();
    Set<Integer> pathVisited = new HashSet<>();

    for (Integer node :map.keySet()) {
        if (!visited.contains(node)) {
            if (dfs(node,map, visited, pathVisited))
                return false;
        }
    }

    return true;
}
    boolean dfs(int node,
            Map<Integer, List<Integer>> graph,
            Set<Integer> visited,
            Set<Integer> pathVisited) {

    visited.add(node);
    pathVisited.add(node);

    for (int nei : graph.getOrDefault(node, new ArrayList<>())) {

        if (!visited.contains(nei)) {
            if (dfs(nei, graph, visited, pathVisited))
                return true;
        }
        else if (pathVisited.contains(nei)) {
            return true;
        }
    }

    pathVisited.remove(node);

    return false;
}
}