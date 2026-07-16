class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        long a[]=new long[n];
        long max=nums[0];
        long sum=0L;
        for(int i=0;i<n;i++)
        {
            max=(long)Math.max(max,nums[i]);
            a[i]=gcd(max,nums[i]);
        }
        Arrays.sort(a);
        int i=0;
        int j=n-1;
        while(i<j)
        {
            sum+=gcd(a[i],a[j]);
            System.out.println(a[i]+" , "+a[j]+" = "+sum);
            i++;
            j--;
        }
         return sum;
    }
    long gcd(long a ,long b)
    {
       while(b!=0) {
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a; 
    }
 }