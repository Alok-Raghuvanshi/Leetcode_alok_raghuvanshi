class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max=Integer.MIN_VALUE;
        int r=matrix.length;
        int c=matrix[0].length;
        int m[][]=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                max=Math.max(max,1+increase(i,j,r,c,matrix,m));
            }
        }
        return max;
    }
    int increase(int i,int j,int r,int c,int nums[][],int m[][])
    {
        int ans=0;
        if(i>=r||i<0||j>=c||j<0)
        return 0;
        if(m[i][j]!=0)
        return m[i][j];
        else
        {
        if(i+1<r&&nums[i][j]<nums[i+1][j])
        ans= Math.max(ans,1+increase(i+1,j,r,c,nums,m));
        if(i-1>=0&&nums[i][j]<nums[i-1][j])
        ans= Math.max(ans,1+increase(i-1,j,r,c,nums,m));
        if(j+1<c&&nums[i][j]<nums[i][j+1])
        ans= Math.max(ans,1+increase(i,j+1,r,c,nums,m));
        if(j-1>=0&&nums[i][j]<nums[i][j-1])
        ans= Math.max(ans,1+increase(i,j-1,r,c,nums,m));
        
        m[i][j]=ans;
        return m[i][j];
        }
    }
}
