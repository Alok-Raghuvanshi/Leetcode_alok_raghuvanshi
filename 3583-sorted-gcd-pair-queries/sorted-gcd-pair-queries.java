import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x:nums)
            max = Math.max(max, x);

        int[] freq = new int[max+1];
        for (int x:nums)
            freq[x]++;

        long[] cnt = new long[max+1];

        for (int d=1;d<=max;d++) {
            for (int multiple=d;multiple<=max;multiple+=d) {
                cnt[d] += freq[multiple];
            }
        }

        long[] exactPairs = new long[max+1];

        for (int d=max; d>=1;d--) {
            long pairs = cnt[d]*(cnt[d]-1)/2;
            for (int multiple=d*2;multiple<=max;multiple+=d) {
                pairs -= exactPairs[multiple];
            }
            exactPairs[d] = pairs;
        }

        // prefix sums
        long[] prefix = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            prefix[d] = prefix[d - 1] + exactPairs[d];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k=queries[i]+1; 
            int l=1,r=max;
            while (l<r) {
                int mid=(l+r)/2;
                if (prefix[mid]>=k)
                    r = mid;
                else
                    l = mid+1;
            }
            ans[i] = l;
        }
        return ans;
    }
}