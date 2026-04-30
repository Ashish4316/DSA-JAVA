class Solution {
    int n;
    int m;
    int [][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n+1][m+1][k+1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= m;j++){
                for(int u = 0;u <= k;u++){
                    dp[i][j][u] = Integer.MIN_VALUE;
                }
            }
        }
        return find(grid,0,0,k);
    }
    public int find(int [][] grid,int i,int j,int k){
        if(i >= n || j >= m){
            return -1;
        }
        if(dp[i][j][k] != Integer.MIN_VALUE){
            return dp[i][j][k];
        }
        int cost = 0;
        if(grid[i][j] > 0) cost = 1;  
        if(i == n-1 &&  j == m-1){
            if(k - cost < 0){
                return -1;
            } 
            else{
                return grid[i][j];
            }
        }
        if(k - cost < 0){
            return -1;
        }
        int right = find(grid,i,j+1,k-cost);
        int down =  find(grid,i+1,j,k-cost);
        if(right != -1) right += grid[i][j];
        if(down != -1) down += grid[i][j];
        return dp[i][j][k] = Math.max(right,down);
    }
}