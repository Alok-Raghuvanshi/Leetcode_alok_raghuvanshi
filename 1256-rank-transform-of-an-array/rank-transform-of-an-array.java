class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ar = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ar);
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=arr.length;
        int t=1;
        for(int i=0;i<n;i++)
        {
            if(i>=1&&ar[i]==ar[i-1])
            {
            continue;
            }
            map.put(ar[i],t++);   
        }
        //System.out.println(map);
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
           ans[i]=map.get(arr[i]);
        }
        return ans;
    }
}