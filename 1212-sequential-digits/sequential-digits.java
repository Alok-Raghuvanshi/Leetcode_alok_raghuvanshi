class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>l=new ArrayList<>();
        
        int start=start((low+"").length());
        int add=addition((start+"").length());
        while(start<=high)
        {
            int last=start%10;
            if(last!=9)
            {
                if(start>=low&&start<=high)
                l.add(start);

                start+=add;
            }
            else
            {
                if(start>=low&&start<=high)
                   l.add(start);

                   start=start((start+"").length()+1);
                   add=addition((start+"").length());
            }
        }
        return l;
    }
        int addition(int n)
        {
            int i=0;
            while((i+"").length()<n)
            {
                i=i*10+1;
            }
            return i;
        }
        int start(int n)
        {
            int num = 0;
            for(int i=1;i<=n;i++)
               num=num*10+i;

                 return num;
        }
 }