class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
    return false;
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int p:hand)
       {
        map.put(p,map.getOrDefault(p,0)+1);
       }
       Arrays.sort(hand);
       int g=0;
       int i=0;
       for(int j=0;j<hand.length/groupSize;j++)
       {
        while(map.get(hand[i])==0) i++;
        int start=hand[i];
        map.put(start,map.get(start)-1);
        g=1;
        while(g!=groupSize)
        {
            if(!map.containsKey(start+1)||map.get(start+1)==0) 
            return false;
            else
            {
               map.put(start+1,map.get(start+1)-1);
            start++;
            }
            g++;
        }
       }
       return true;
    }
}
