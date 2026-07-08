import java.util.*;

class Solution {
    static final long MOD = 1000000007L;
    public int[] sumAndMultiply(String s, int[][] queries) {

        ArrayList<Integer> digit = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digit.add(d);
                index.add(i);
            }
        }
        int k = digit.size();
        long[] prefSum = new long[k + 1];
        long[] prefNum = new long[k + 1];
        long[] pow10 = new long[k + 1];

        // powers of 10
        pow10[0] = 1;
        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        for (int i = 0; i < k; i++) {
            prefSum[i + 1] = prefSum[i] + digit.get(i);
            prefNum[i + 1] = (prefNum[i] * 10 + digit.get(i)) % MOD;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(index, l);
            int right = upperBound(index, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            long sum = prefSum[right + 1] - prefSum[left];
            int len = right - left + 1;
            long num = (prefNum[right + 1]- prefNum[left] * pow10[len]) % MOD;
            if (num < 0)
                num += MOD;
            ans[i] = (int) ((sum % MOD) * num % MOD);
        }
        return ans;
    }

    private int lowerBound(ArrayList<Integer> arr, int x) {
        int l = 0, r = arr.size();

        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    int upperBound(ArrayList<Integer> arr, int x) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;

            if (arr.get(mid) > x)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}