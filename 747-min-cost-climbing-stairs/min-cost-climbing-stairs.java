class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(mincost(cost,cost.length-1,dp),mincost(cost,cost.length-2,dp));
    }
    int mincost(int cost[],int idx,int dp[])
   {
    if(idx==0||idx==1) return cost[idx];
    if(dp[idx]!=-1) return dp[idx];
    return dp[idx]=cost[idx]+Math.min(mincost(cost,idx-1,dp),mincost(cost,idx-2,dp));
   }
}
