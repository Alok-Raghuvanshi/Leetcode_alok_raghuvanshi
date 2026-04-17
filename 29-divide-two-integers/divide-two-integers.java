class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==1) return dividend;
        int b=1;
        if(dividend>=0&&divisor>=0||dividend<0&&divisor<0)
        b=0;
       if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long dvd=Math.abs((long)dividend);
        long dsr=Math.abs((long)divisor);
        long d,ans=0;
        while(dvd>=dsr)
        {
            d=check(dvd,dsr);
            ans+=d;
            dvd=dvd-dsr*d;
        }
        if(b==0)
        return (int)ans;
        else
        return -(int)ans;
    }
    long check(long dnd,long dsr)
    {
        int i=0;
        while(Math.pow(2,i)*dsr<=dnd)
        {
            i++;
        }
        return (long)Math.pow(2,i-1);
        
    }
}