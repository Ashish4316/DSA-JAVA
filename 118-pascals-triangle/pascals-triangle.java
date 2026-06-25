class Solution{
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1;i <= numRows;i++){
            List<Integer> helper = new ArrayList<>();
            for(int j = 0;j < i;j++){
                if(j == 0 || j == i-1){
                    helper.add(1);
                }else{
                    helper.add(list.get(i-2).get(j-1) + list.get(i-2).get(j));
                }
            }
            list.add(new ArrayList<>(helper));
        }
        return list;
    }
}