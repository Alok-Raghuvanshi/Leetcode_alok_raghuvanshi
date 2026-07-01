class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean b[]=new boolean[n+1];
        Arrays.fill(b,true);
        b[0]=false;
        b[1]=false;

        for(int i=2;i*i<=n;i++)
        {
            if(b[i])
            {
                for(int j=i*i;j<=n;j+=i)
                b[j]=false;
            }
        }
 
          List<List<Integer>>out=new ArrayList<>();
        for(int i=2;i<(n/2)+1;i++)
        {
           List<Integer>l=new ArrayList<>();
           if(b[i]&&b[n-i])
           {
            out.add(Arrays.asList(i,n-i));
           }
        }
        return out;
    }
}