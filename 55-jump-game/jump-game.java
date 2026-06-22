class Solution {
    public boolean canJump(int[] nums) {
      int n=nums.length;
      int gs=n-1;
      int i=n-1;
      while(i>0)
      {
        int j=1;
        if(nums[i-1]>=j)
        {
            gs=i-1;
            i--;
        }
        else{
        while(i>0&&nums[i-1]<j)
        {
         i--;
         j++;
        }
        }
      }
      if(gs==0) return true;
      else
      return false;  
    }
}
