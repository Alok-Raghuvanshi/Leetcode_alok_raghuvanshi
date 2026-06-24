class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

       for(int[]row:dp) {
          Arrays.fill(row, -1);
       }
            return unique(0,0,m-1,n-1,dp);
    }
    int unique(int i,int j,int m,int n,int dp[][])
    {
        if(i>m||j>n) return 0;
        if(i==m&&j==n)
        {
        return 1;
        }
            if(dp[i][j]!=-1)
            return dp[i][j];

        return dp[i][j]=unique(i+1,j,m,n,dp)+unique(i,j+1,m,n,dp);
        
    }
}
