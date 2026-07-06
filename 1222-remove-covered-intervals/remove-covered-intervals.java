class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        int m=0;
        Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0])
                 return b[1] - a[1];
                 return a[0] - b[0];
                   });
             int end=0;
        for(int i=0;i<n;i++)
        {
            if(intervals[i][1]>end)
            {
                m++;
                end=intervals[i][1];

            }
        }
        return m;
    }
}