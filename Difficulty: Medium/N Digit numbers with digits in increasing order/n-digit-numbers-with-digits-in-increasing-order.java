
class Solution {
    public static ArrayList<Integer> increasingNumbers(int n){
        ArrayList<Integer> list = new ArrayList<>();
        if(n == 1){
            for(int i = 0;i <= 9;i++){
                list.add(i);
            }
            return list;
        }
        for(int i = 1;i <= 9;i++){
            find(n,i,list);
        }
        return list;
    }
    public static void find(int n,int num,ArrayList<Integer> list){
        if(n == 1){
            list.add(num);
            return;
        }
        for(int i = 1;i <= 9;i++){  
            if(num % 10 >= i){ 
                continue;
            }
            int newNum = num * 10 + i;
            find(n-1,newNum,list);
        }
    }
}
