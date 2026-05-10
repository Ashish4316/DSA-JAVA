class Solution{
    int n;
    int [] dp;
    public int maximumJumps(int[] nums, int target){
        n = nums.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i < n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(Math.abs(nums[j] - nums[i]) <= target){
                    graph.get(i).add(j);
                }
            }
        }
        dp = new int[n];
        Arrays.fill(dp,-2);
        return dfs(0,graph);
    }
    public int dfs(int i,ArrayList<ArrayList<Integer>> graph){
        if(i == n-1){
            return 0;
        }
        if(dp[i] != -2){
            return dp[i];
        }
        int maxJumps = -1;
        for(int node : graph.get(i)){
            int res = dfs(node, graph);
            if(res != -1){
                maxJumps = Math.max(maxJumps, 1 + res);
            }
        }
        return dp[i] = maxJumps;
    }
}