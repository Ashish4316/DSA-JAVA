class DSU{
    int [] parent;
    int [] rank;
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i; 
        }
    }
    public int find(int x) {
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;
        if(rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }else if(rank[pv] < rank[pu]) {
            parent[pv] = pu;
        }else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}
class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public int evenSumSubgraphs(int[] nums, int[][] edges){
        int n = nums.length;
        int [] num = new int[n];
        for(int i = 0;i < num.length;i++){
            num[i] = i;
        }
        findUniqSub(num,0,new ArrayList<>());
        int ans = 0;
        for(ArrayList<Integer> sub : list){
            if(sub.size() == 0) continue;
            int sum = 0;
            for(int node : sub) sum += nums[node];
            if(sum % 2 != 0) continue;
            HashSet<Integer> set = new HashSet<>(sub);
            DSU dsu = new DSU(nums.length);
            for(int[] e : edges){
                int u = e[0], v = e[1];
                if(set.contains(u) && set.contains(v))dsu.union(u, v);
            }
            HashSet<Integer> parents = new HashSet<>();
            for(int x : sub){
                parents.add(dsu.find(x));
            }
            if(parents.size() == 1)ans++;
        }
        return ans;
    }
    public void findUniqSub(int [] num,int start,ArrayList<Integer> helper){
        list.add(new ArrayList<>(helper));
        for(int i = start;i < num.length;i++){
            if(i != start && num[i] == num[i-1]){
                continue;
            }
            helper.add(num[i]);
            findUniqSub(num,i + 1,helper);
            helper.remove(helper.size() - 1);
        }
    }
}