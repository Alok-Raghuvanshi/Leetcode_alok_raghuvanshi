class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums)
        sum+=i;
        if (Math.abs(target) > sum)
        return 0;
        int a[][]=new int[nums.length][(2*sum)+1];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<2*sum+1;j++)
            {
                a[i][j]=-1001;
            }
        }
        return target(0,nums,0,target,a,sum);
    }
    int  target(int i,int nums[],int sum,int t,int a[][],int total)
    {
        if(i>=nums.length)
        {
          if(sum==t)
          return 1;
          else
          return 0;
        }
             if(a[i][sum+total]!=-1001)
             return a[i][sum+total];
        else
        a[i][sum+total]=target(i+1,nums,sum-nums[i],t,a,total)+target(i+1,nums,sum+nums[i],t,a,total);
        return a[i][sum+total];

    }
}
