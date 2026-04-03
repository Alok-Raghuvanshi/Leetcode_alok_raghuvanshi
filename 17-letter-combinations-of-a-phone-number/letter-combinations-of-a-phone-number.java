class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String>map=new HashMap<>();
        List<String>l=new ArrayList<>();
        StringBuilder ans=new StringBuilder();
        if(digits.length()==0)
        return l;
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
            combination(digits,map,l,ans,0);
        return l;
    }
      void combination(String digits,HashMap<Integer,String>map,List<String>l,StringBuilder ans,int i)
      {

        if(i==digits.length())
        {
        l.add(ans.toString());
        return;
        }
        String str=map.get(digits.charAt(i)-'0');
         for(int j=0;j<str.length();j++)
         {
           ans.append(str.charAt(j));
           combination(digits,map,l,ans,i+1);
           ans.deleteCharAt(ans.length()-1);
         }
      }
}
