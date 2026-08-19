class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
  
HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
for(int i=0;i<reservedSeats.length;i++)
{
        if(map.containsKey(reservedSeats[i][0]-1)){
        HashSet<Integer>ll=map.get(reservedSeats[i][0]-1);
        ll.add(reservedSeats[i][1]-1);
        map.put(reservedSeats[i][0]-1,ll);}
        else
        {
           HashSet<Integer>ll=new HashSet<>();
           ll.add(reservedSeats[i][1]-1);
           map.put(reservedSeats[i][0]-1,ll); 
    }
}
int ans = 2 * (n - map.size());
     for(HashSet<Integer> s : map.values())
     { 
         if(!(s.contains(1)||s.contains(2)||s.contains(3)||s.contains(4))){ 
            if(!(s.contains(5)||s.contains(6)||s.contains(7)||s.contains(8)))
            ans+=2;
            else
            ans++;
            }
           else  if(!(s.contains(5)||s.contains(6)||s.contains(7)||s.contains(8))){ 
            if(!(s.contains(1)||s.contains(2)||s.contains(3)||s.contains(4)))
            ans+=2;
            else
            ans++;
            }
         else if(!(s.contains(3)||s.contains(4)||s.contains(5)||s.contains(6))) ans++;
        }

     return ans;
    }
}