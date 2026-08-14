class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int l=0,r=0;
        int ml=0;
        int a[]=new int[26];
        while(r<n)
        {
            while(r<n&&a[s.charAt(r)-'a']<2)
            {
                a[s.charAt(r)-'a']++;
                r++;
            }
            ml=Math.max(ml,r-l);
            while(r<n&&a[s.charAt(r)-'a']>=2)
            {
                a[s.charAt(l)-'a']--;
                l++;
            }
        }
        return ml;
    }
}