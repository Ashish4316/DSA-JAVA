class Solution {
    int n;
    int m;
    long [][] prefixCol;
    long [][][] dp;
    public long maximumScore(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new long[n+1][m+1][2];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= m;j++){
                for(int k = 0;k < 2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        prefixCol = new long[n + 1][m + 1];
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                prefixCol[j][i] = prefixCol[j-1][i] + grid[j-1][i-1];
            }
        }
        return find(grid,0,0,1);
    }
    public long find(int [][] grid,int pT,int pH,int c){
        if(c == m+1){
            return 0;
        }
        if(dp[pH][c][pT] != -1){
            return dp[pH][c][pT];
        }
        long result = 0;
        for(int h = 0;h <= n;h++){
            long prevScore = 0;
            long currScore =  0;
            if(pT == 0 && h > pH){
                prevScore += prefixCol[h][c-1] - prefixCol[pH][c-1];
            }
            if(pH > h){
                currScore += prefixCol[pH][c] - prefixCol[h][c];
            }
            long cT = prevScore + currScore + find(grid,1,h,c+1);
            long cNt = prevScore + find(grid,0,h,c+1);
            result = Math.max(result, Math.max(cT,cNt));
        }
        return dp[pH][c][pT] = result;
    }
}
