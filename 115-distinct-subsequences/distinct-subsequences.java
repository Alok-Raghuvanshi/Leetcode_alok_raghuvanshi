class Solution {
    public int numDistinct(String s, String t) {
        int m[][]=new int[s.length()+1][t.length()+1];
        for (int[] row : m)
          Arrays.fill(row, -1);
       return ways(0,0,s,t,m); 
    }
    int ways(int i, int j,String s, String t,int m[][])
    {

        if(j==t.length())
        return 1;
        if(i==s.length())
        return 0;
        if(m[i][j]!=-1)
        return m[i][j];
        
        int ans=0;
        if(s.charAt(i)==t.charAt(j))
        ans+= ways(i+1,j+1,s,t,m)+ways(i+1,j,s,t,m); 
        else
        ans+= ways(i+1,j,s,t,m); 
        
        m[i][j]=ans;
        return ans;
    }
}
