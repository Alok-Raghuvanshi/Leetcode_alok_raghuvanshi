class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        for(;;i++)
        {
            if(check(i,t))
            break;
        }
        return i;
    }
    boolean check(int i,int t)
    {
        int n=i;
        int s=1;
        while(n>0)
        {
            int r=n%10;
            s=s*r;
            n=n/10;
        }
        return (s%t==0)?true:false;
    }
}