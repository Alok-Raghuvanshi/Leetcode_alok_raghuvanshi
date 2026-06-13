class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>out=new ArrayList<>();
        int r=heights.length;
        int c=heights[0].length;
        char pacific[][]=new char[r][c];
        char atlantic[][]=new char[r][c];
        for(int i=0;i<c;i++)
        {
        pacific[0][i]='m';
        atlantic[r-1][i]='m';
        }
        for(int i=0;i<r;i++)
        {
            pacific[i][0]='m';
            atlantic[i][c-1]='m';
        }
        for(int i=0;i<c;i++)
        {
          recursion(0,i,r,c,heights,pacific);
          recursion(r-1,i,r,c,heights,atlantic);
        }
        for(int i=0;i<r;i++)
        {
          recursion(i,0,r,c,heights,pacific);
          recursion(i,c-1,r,c,heights,atlantic);
        }
        for(int i=0;i<r;i++)
        {
          for(int j=0;j<c;j++)
          {
            if(pacific[i][j]=='m'&&atlantic[i][j]=='m')
            out.add(Arrays.asList(i,j));
          }
        }
        return out;
    }
    void recursion(int i,int j,int r,int c,int h[][],char mat[][])
    {
      mat[i][j]='m';
      if(i+1<r && h[i+1][j]>=h[i][j] && mat[i+1][j]!='m')
      recursion(i+1,j,r,c,h,mat);

    if(i-1>=0 && h[i-1][j]>=h[i][j] && mat[i-1][j]!='m')
    recursion(i-1,j,r,c,h,mat);

    if(j+1<c && h[i][j+1]>=h[i][j] && mat[i][j+1]!='m')
    recursion(i,j+1,r,c,h,mat);

    if(j-1>=0 && h[i][j-1]>=h[i][j] && mat[i][j-1]!='m')
    recursion(i,j-1,r,c,h,mat);
    }
}