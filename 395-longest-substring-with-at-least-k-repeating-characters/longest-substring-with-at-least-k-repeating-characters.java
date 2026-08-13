class Solution {
    public int longestSubstring(String s, int k) {
        return solve(0,s.length(),s,k);
    }
    int solve(int l,int r,String s,int k)
    {
        if(r-l<k)
        return 0;
        int a[]=new int[26];
        for(int i=l;i<r;i++)
        {
            char ch=s.charAt(i);
            a[ch-'a']++;
        }

        int n=a.length;
        for(int j=l;j<r;j++)
        {
            if(a[s.charAt(j)-'a']<k)
            {
                int left=solve(l,j,s,k);
                int right=solve(j+1,r,s,k);
                return Math.max(left,right);
            }
        }
        return r-l;
    }
}