class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans=-1;
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
       for(int i:nums)
       {
       map.put(i,map.getOrDefault(i,0)+1);
       }
       if(k==1)
       {
        while(map.size()!=0)
        {
            int largestKey = Collections.max(map.keySet());
            if(map.get(largestKey)>1)
            map.remove(largestKey);
            else
            return largestKey;
        }
        return ans;
       }
       else if(k==n)
       {
        return Collections.max(map.keySet());
       }
       else
       {
        if(map.get(nums[0])==1&&map.get(nums[n-1])==1) return Math.max(nums[0],nums[n-1]);
       else if(map.get(nums[0])==1&&map.get(nums[n-1])>1) return nums[0];
        else if(map.get(nums[n-1])==1&&map.get(nums[0])>1) return nums[n-1];
       else
        return -1;
       }
    }
}