class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        ArrayList<ArrayList<Long>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            long u = (long)edge[0];
            long v = (long)edge[1];
            adj.get((int)u).add(v);
        }
        return dfs(0L, baseTime, adj);
    }

    public long dfs(long src, int[] baseTime, ArrayList<ArrayList<Long>> adj){
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(long node : adj.get((int)src)){
            long curr = dfs(node, baseTime, adj);
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }
        if(max == Long.MIN_VALUE) return baseTime[(int)src];
        long own = (max - min) + baseTime[(int)src];
        long bst = own + max;
        return bst;
    }
}

