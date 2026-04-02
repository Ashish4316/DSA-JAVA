class Solution {
    int n;
    int m;
    int [][][] dp;
    public int maximumAmount(int[][] coins) {
        n = coins.length;
        m = coins[0].length;
        dp = new int[n + 1][m + 1][3];
        for(int [][] rows : dp){
            for(int [] row : rows){
                Arrays.fill(row,-(int)1e9);
            }
        }
        return dfs(0,0,coins,2);
    }
    public int dfs(int i,int j,int [][] coins,int k){
        if(i < 0 || j < 0 || i >= n || j >= m){
            return Integer.MIN_VALUE;
        }
        if(i == n-1 && j == m-1){
            if(coins[i][j] >= 0){
                return coins[i][j];
            }else{
                if(k > 0){
                    return 0;
                }
                return coins[i][j];
            }
        }
        if(dp[i][j][k] != -(int)1e9){
            return dp[i][j][k];
        }
        int gain = Integer.MIN_VALUE;
        int steal = Integer.MIN_VALUE;
        int stealPrevent = Integer.MIN_VALUE;
        if(coins[i][j] >= 0){
            int down = dfs(i+1,j,coins,k);
            int right = dfs(i,j+1,coins,k);
            if(down != Integer.MIN_VALUE){
                gain = Math.max(gain, coins[i][j] + down);
            }
            if(right != Integer.MIN_VALUE){
                gain = Math.max(gain, coins[i][j] + right);
            }
        }else{
            if(k > 0){
                stealPrevent = Math.max(dfs(i + 1,j,coins,k-1),dfs(i,j+1,coins,k-1));
            }
            int down = dfs(i+1,j,coins,k);
            int right = dfs(i,j+1,coins,k);
            if(down != Integer.MIN_VALUE){
                steal = Math.max(steal, coins[i][j] + down);
            }
            if(right != Integer.MIN_VALUE){
                steal = Math.max(steal, coins[i][j] + right);
            }
        }
        return dp[i][j][k] = Math.max(gain,Math.max(steal,stealPrevent));
    }
}