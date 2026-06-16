class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int r=edges.length;
        int newedge[][]=new int[r-1][2];
        int a[]=new int[2];
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        for(int i=r-1;i>=0;i--)
        {
          map=graph(edges[i][0],edges[i][1],edges);
          boolean vis[]=new boolean[r];
          if((!hasCycle(1,-1,vis,map))&&connected(map,r))
          {
            a[0]=edges[i][0];
            a[1]=edges[i][1];
            break;
          }
        }
        return a;
    }
    HashMap<Integer,List<Integer>> graph(int n1,int n2,int edges[][])
    {
      int r=edges.length;
         HashMap<Integer,List<Integer>>map=new HashMap<>();
         for(int i=r;i>=1;i--)
          {
         map.put(i,new ArrayList<>());
          }
          for(int i=r-1;i>=0;i--)
          {
             if((edges[i][0]==n1&&edges[i][1]==n2)) continue;
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
          }  
          return map;   
    }
    boolean connected(HashMap<Integer,List<Integer>>map,int r)
    {
         boolean vis[]=new boolean[r];
         dfs(1,vis,map);
         for(boolean b:vis)
         {
          if(!b)
          return false;
         }
         return true;
    }
    void dfs(int node,boolean vis[],HashMap<Integer,List<Integer>>map)
    {
      if(!vis[node-1]) vis[node-1]=true;

       List<Integer>l=map.get(node);
      for(int t:l)
      {
        if(!vis[t-1])
        dfs(t,vis,map);
      }
    }
    boolean hasCycle(int node, int parent,
                 boolean[] vis,
                 HashMap<Integer,List<Integer>> map)
{
    vis[node - 1] = true;

    for(int nbr : map.get(node))
    {
        if(!vis[nbr - 1])
        {
            if(hasCycle(nbr, node, vis, map))
                return true;
        }
        else if(nbr != parent)
        {
            return true;
        }
    }

    return false;
}
}
