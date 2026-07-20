class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
       int r=grid.length;
       int c=grid[0].length;
       int t=r*c;
       k=k%(t);
       int ans[][]=new int[r][c];
       List<List<Integer>>result=new ArrayList<>();

       for(int i=0;i<r;i++)
       {
        for(int j=0;j<c;j++)
        {
          int idx=(i*c+j);
          int nidx=(idx+k)%(t);

          ans[nidx/c][nidx%c]=grid[i][j]; 
        }
       }

        for(int i=0;i<r;i++)
       {
        List<Integer>l=new ArrayList<>();
        for(int j=0;j<c;j++)
        {
          l.add(ans[i][j]);
        }
         result.add(l);
       }
    return result;
    }
}