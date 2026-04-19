class Solution {
    public int countSubstrings(String s) {
        int i=0;
        int n=s.length();
        int count=0;
        for(i=0;i<n;i++)
        {
           int c1= expand(s,i,i,0);   //for odd palindrome 
           int c2= expand(s,i,i+1,0); //for even palindrome
           count=count+c1+c2;
        }
        return count;
    }
    int expand(String s,int l,int r,int count)
    {
        while(l>=0&&l<=r&&r<s.length()&&s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
            count++;
        }
        return count;
    }
}
