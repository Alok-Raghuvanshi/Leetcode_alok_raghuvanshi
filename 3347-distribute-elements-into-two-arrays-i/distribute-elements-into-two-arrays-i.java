class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer>l1=new ArrayList<>();
        List<Integer>l2=new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        int n=nums.length;
        for(int i=2;i<n;i++)
        {
            if(l1.get(l1.size()-1)>l2.get(l2.size()-1))
            l1.add(nums[i]);
            else
            l2.add(nums[i]);
        }
        int s1=l1.size();
        for(int k=0;k<n;k++)
        {
            if(k<s1) nums[k]=l1.get(k);
            else
            nums[k]=l2.get(k-s1);
        }
        return nums;
    }
}