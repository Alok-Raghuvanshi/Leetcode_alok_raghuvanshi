class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xor=0;
        boolean nz=false;
        for(int i:nums)
        {
         xor=xor^i;
         if(i!=0)
         nz=true;
        }

        if(xor!=0)
        return n;
        else 
        {
            if(nz==true)
            return n-1;
            else
            return 0;
        }
    }
}