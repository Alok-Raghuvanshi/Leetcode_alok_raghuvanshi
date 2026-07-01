class Solution {
    public int change(int amount, int[] coins) {
        int m[][]=new int[coins.length][(amount+1)];
        for(int a[]:m)
        Arrays.fill(a,-1);
       return ways(0,0,coins,amount,m); 
    }
    int ways(int i,int s,int c[],int a,int m[][])
    {
        if(s==a)
        return 1;
        if(i>=c.length)
        return 0;
        if(s>a)
        return 0;
        
        if(m[i][s]!=-1)
        return m[i][s];
        else
        {
        m[i][s]= ways(i+1,s,c,a,m)+ways(i,s+c[i],c,a,m);
        return m[i][s];
        }
    }
}
