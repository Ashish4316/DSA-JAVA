class Solution {
    int n = 0;
    int [] free;
    int [][] dp;
    public int maximumSaleItems(int[][] items, int budget){
        n = items.length;
        free = new int[n];
        dp = new int[n+1][budget+1];
        for(int [] d : dp){
            Arrays.fill(d,-1);
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i != j){
                    if(items[j][0] % items[i][0] == 0) free[i]++;
                }
            }
        }
        return solve(0,items,budget);
    }
    public int solve(int i,int [][] items,int budget){
        if(i == n){
            return 0;
        }
        if(dp[i][budget] != -1){
            return dp[i][budget];
        }
        int factor = items[i][0];
        int price = items[i][1];
        int pick = Integer.MIN_VALUE;
        if(budget-price >= 0){
            pick = 1 + free[i] + solve(i+1, items, budget - price);
            int extra = 1 + solve(i, items, budget - price);
            if(extra != Integer.MIN_VALUE){
                pick = Math.max(pick,extra);
            }
        }
        int notpick = solve(i+1,items,budget);
        return dp[i][budget] = Math.max(pick,notpick);
    }
}