class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int l=0;
        int ml=Integer.MIN_VALUE;
        int left=0;
        HashMap<Integer,Integer>map=new HashMap<>();
            while(i<n)
            {
               if(!map.containsKey(nums[i]))
               map.put(nums[i],map.getOrDefault(nums[i],0)+1);
               else
               map.put(nums[i],map.get(nums[i])+1);
              l++;
               
                while(left<n&&map.get(nums[i])>k)
                {
                    map.put(nums[left],map.get(nums[left])-1);
                    left++;
                    l--;
                }
               i++;
            ml=Math.max(ml,l);
            }
            return ml;
        }
    }
