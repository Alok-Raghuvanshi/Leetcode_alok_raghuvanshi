class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         HashMap<Integer,List<Integer>>map=new HashMap<>();
       HashSet<Integer>set=new HashSet<>();
       int result[]=new int[numCourses];
       List<Integer>list=new ArrayList<>();
       int r=prerequisites.length;
       for(int i=0;i<r;i++)
       {
            map.computeIfAbsent(prerequisites[i][1],
        k -> new ArrayList<>())
        .add(prerequisites[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
    Set<Integer> pathVisited = new HashSet<>();

    for(int i=0;i<numCourses;i++)
{
    if(!visited.contains(i))
    {
        if(dfs(i,map,visited,pathVisited,list))
            return new int[0];
    }
}
     Collections.reverse(list);
     for(int i=0;i<list.size();i++)
     result[i]=list.get(i);
    return result;
}
    boolean dfs(int node,
            Map<Integer, List<Integer>> graph,
            Set<Integer> visited,
            Set<Integer> pathVisited,
            List<Integer>l) {

    visited.add(node);
    pathVisited.add(node);

    for (int nei : graph.getOrDefault(node, new ArrayList<>())) {

        if (!visited.contains(nei)) {
            if (dfs(nei, graph, visited, pathVisited,l))
                return true;
        }
        else if (pathVisited.contains(nei)) {
            return true;
        }
    }

    pathVisited.remove(node);
     l.add(node);
    return false;
    }
}
