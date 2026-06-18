class Solution {
    int MOD = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges){
        int n = edges.length + 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i <= n;i++){
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int [] v = new int[n + 1];
        v[1] = 1;
        for(int [] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int lvl = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int node = q.poll();
                for(int adjNode : adj.get(node)){
                    if(v[adjNode] != 1){
                        v[adjNode] = 1;
                        q.add(adjNode);
                    }
                }
            }
            lvl++;
        }
        return (int) maxPow(2,lvl-2);
    }
    public long maxPow(long a, long b) {
        long ans = 1;
        while(b > 0){
            if((b & 1) == 1){
                ans = (ans * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }
}