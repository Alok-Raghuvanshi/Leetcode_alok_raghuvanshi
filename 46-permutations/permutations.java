class Solution {
    public List<List<Integer>> permute(int[] nums) { 
      List<List<Integer>>outer=new ArrayList<>();
      List<Integer>l=new ArrayList<>();
      boolean used[]=new boolean[nums.length];
      permutations(used,0,nums,outer,l);
      return outer; 
    }
    void permutations(boolean used[],int i,int nums[],List<List<Integer>>outer, List<Integer>l)
    {
      if(l.size()==nums.length)
      {
      outer.add(new ArrayList<>(l));
      return;
      }
       for(int j=i;j<i+nums.length;j++)   //traversing and choosing n elements which is not used by circulation traversing
       {
        if(used[j%nums.length]==true) continue;
    
        used[j%nums.length]=true;
        l.add(nums[j%nums.length]);
        permutations(used,i+1,nums,outer,l);
        l.remove(l.size()-1);          //backtrack
        used[j%nums.length]=false;     //backtrack
        }
       }
    }
