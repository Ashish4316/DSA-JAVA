class Solution {
    public void rotate(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < m;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m/2;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[i][m - j - 1];
                grid[i][m - j - 1] = temp;
            }
        }
    }
}