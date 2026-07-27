class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int m1=0;
        int m2=0;

        for(int i=0;i<n;i++)
        {
         int num=nums[i];
         if(num>=m1)
         {
            m2=m1;
            m1=num;
         } 
         else if(num>m2)
         m2=num;

        }
        return (m1-1)*(m2-1);
    }
}