class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
        int num=1;
        for(int i=1;i<=9;i++)
        {   num=i;
            for(int j=i;j<9;j++)
            {  
              num=num*10+(j+1);
              if(num>=low&&num<=high)
              {
                list.add(num);
              }
            }
        }
         Collections.sort(list);
         return list;
    }
    
}