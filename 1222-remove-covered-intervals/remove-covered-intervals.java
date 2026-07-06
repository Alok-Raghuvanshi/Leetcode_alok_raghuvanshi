class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        int m=n;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            int cs=intervals[i][0];
            int ce=intervals[i][1];
            for(int j=0;j<n;j++)
            {
                if(i==j) continue;
                if(intervals[j][0]<=cs&&ce<=intervals[j][1])
                {
                 m--;
                 break;
                }
            }
        }
        return m;
    }
}