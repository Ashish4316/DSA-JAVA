class Solution{
    public List<Integer> findGoodIntegers(int n){
        int root = (int) Math.cbrt(n);
        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        for(int i = 1;i <= root;i++){
            for(int j = i+1;j <= root;j++){
                int sum = (int)Math.pow(i,3) + (int)Math.pow(j,3);
                if(sum > n){
                    break;
                }
                if(set.contains(sum) && sum <= n){
                    set2.add(sum);
                }
                set.add(sum);
            }
        }
        List<Integer> ans = new ArrayList<>(set2);
        return ans;
    }
}