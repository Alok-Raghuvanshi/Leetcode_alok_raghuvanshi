class Solution {
    public int rob(int[] nums) {
        
   if(nums.length==1)
        return nums[0];

        int num[]=new int[nums.length-1];
        int dp1[]=new int[nums.length];
        int dp2[]=new int[num.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
        for(int i=0;i<num.length;i++)
        num[i]=nums[i];
      return Math.max((house(num,0,dp2)),house(nums,1,dp1));  
    }
    int house(int num[],int idx,int dp[])
    {
        if(idx>=num.length) return 0;
    
        if(dp[idx]!=-1) return dp[idx];
        int rob=num[idx]+house(num,idx+2,dp);
        int skip=house(num,idx+1,dp);

        return dp[idx]=Math.max(rob,skip);
    }
}
