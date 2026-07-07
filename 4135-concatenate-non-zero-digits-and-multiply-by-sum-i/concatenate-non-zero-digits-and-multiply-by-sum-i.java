class Solution {
    public long sumAndMultiply(int n) {
    Long sum=0L;
    StringBuilder concat=new StringBuilder();
    String st=n+"";

    for(int i=0;i<st.length();i++)
    {
        char ch=st.charAt(i);
        if(ch!='0')
        {
            concat.append(ch);
            sum+=ch-'0';
        }
    }
      if(concat.length()!=0)
        return sum*Long.parseLong(concat.toString());
        else
        return 0;
        
    }
}