class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        int g=0;
        for(int i=0;i<n;i++)
        {
            g=0;
            for(int j=i;j<n;j++)
            {
                g=gcd(g,nums[j]);
               if(g==k)
               count++;
               else if(g<k)
               break;
            }
        }
        return count;
    }
        int gcd(int a,int b)
        {
            while(b!=0)
            {
                int temp=b;
                b=a%b;
                a=temp;
            }
            return a;
        }
    }