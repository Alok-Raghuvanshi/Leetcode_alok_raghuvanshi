class Solution {
    public List<List<String>> partition(String s) {
      List<String>l=new ArrayList<>();
      List<List<String>>o=new ArrayList<>();
      palindrome(s,0,l,o);
      return o;
    }
    void palindrome(String s,int i,List<String>l,List<List<String>>o)
    {
      if(i==s.length())
      {
      o.add(new ArrayList<>(l));
      return;
      }
      for(int j=i;j<s.length();j++)
      {
        if(palin(s.substring(i,j+1)))
        {
          l.add(s.substring(i,j+1));
        palindrome(s,j+1,l,o);
        l.remove(l.size()-1);
        }
      }
    }
    boolean palin(String s)
    {
      int i=0;
      int j=s.length()-1;
      while(i<=j)
      {
        if(s.charAt(i)!=s.charAt(j))
        return false;

        i++;
        j--;
      }
      return true;
    }
}
