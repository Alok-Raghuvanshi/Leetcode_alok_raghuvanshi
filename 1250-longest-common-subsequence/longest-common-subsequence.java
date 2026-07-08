class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int memo[][]=new int[text1.length()][text2.length()];
        for(int a[]:memo)
        Arrays.fill(a,-1);
        return ways(0,0,text1.length(),text2.length(),text1,text2,memo);
    }
    int ways(int i,int j,int n,int m,String s1,String s2,int memo[][])
    {
        if(i>=n||j>=m)
        return 0;
        
        if(memo[i][j]!=-1)
        return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        {
        memo[i][j]= 1+ways(i+1,j+1,n,m,s1,s2,memo);
        return memo[i][j];
        }
        memo[i][j]=Math.max(ways(i,j+1,n,m,s1,s2,memo),ways(i+1,j,n,m,s1,s2,memo));
        return memo[i][j];
    }
}
