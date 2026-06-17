class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     wordList.add(beginWord);
     System.out.println(wordList);
     int n=wordList.size();

      boolean flag=true;
      int idx=-1;
     for(int i=0;i<n;i++)
     {
        if(wordList.get(i).equals(endWord))
        {
            idx=i;
            break;
        }
     }
     int initial=n-1;
     int target;
     if(idx==-1) return 0;
     else
      target=idx;
     HashMap<Integer,List<Integer>>map=new HashMap<>();
     for(int i=0;i<n;i++)
     {
        map.put(i,new ArrayList<>());
     }
     for(int i=0;i<n;i++)
     {
        for(int j=0;j<n;j++)
        {
          if(i==j) continue;
          else
          {
            if(difference(wordList.get(i),wordList.get(j)))
            {
                    map.get(i).add(j);
            }
          }
        }
     }
         boolean vis[]=new boolean[n];
        return bfs(1,vis,initial,target,map);
    }
    boolean difference(String s1,String s2)
    {
        int n=s1.length();
        int flag=0;
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)!=(s2.charAt(i)))
            flag++;
        }
       return (flag==1)?true:false;
    }
    int bfs(int count,boolean vis[],int start,int end,HashMap<Integer,List<Integer>>map)
    {
        Queue<Integer> queue = new LinkedList<>();
        vis[start] = true;
        queue.add(start);

        while(!queue.isEmpty())
        {
          int s=queue.size();
             for(int i=0;i<s;i++)
             {
              int node=queue.poll();
             if(node==end) return count;

            for (int neighbor : map.get(node)) 
            {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    queue.add(neighbor);
                }
        }
             }
             count++;
    }
    return 0;
}
}