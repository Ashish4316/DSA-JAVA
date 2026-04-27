class Solution {
    int n;
    int m;
    
    public boolean hasValidPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int [][] visited = new int[n][m];
        return dfs(grid,0,0,visited);
    }
    
    public boolean dfs(int [][] grid,int i,int j,int [][] visited){
        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] == 1){
            return false;
        }
        
        if(i == n-1 && j == m-1){
            return true;
        }
        
        visited[i][j] = 1;
        
        if(grid[i][j] == 1){
            return (isValid(grid,i,j,i,j-1) && dfs(grid,i,j-1,visited)) || (isValid(grid,i,j,i,j+1) && dfs(grid,i,j+1,visited));        
        }else if(grid[i][j] == 2){
            return (isValid(grid,i,j,i+1,j) && dfs(grid,i+1,j,visited)) || (isValid(grid,i,j,i-1,j) && dfs(grid,i-1,j,visited));        
        }else if(grid[i][j] == 3){
            return (isValid(grid,i,j,i,j-1) && dfs(grid,i,j-1,visited)) || (isValid(grid,i,j,i+1,j) && dfs(grid,i+1,j,visited));     
        }else if(grid[i][j] == 4){
            return (isValid(grid,i,j,i,j+1) && dfs(grid,i,j+1,visited)) || (isValid(grid,i,j,i+1,j) && dfs(grid,i+1,j,visited));
                   
        }else if(grid[i][j] == 5){
            return (isValid(grid,i,j,i-1,j) && dfs(grid,i-1,j,visited)) || (isValid(grid,i,j,i,j-1) && dfs(grid,i,j-1,visited));
                   
        }else if(grid[i][j] == 6){
            return (isValid(grid,i,j,i-1,j) && dfs(grid,i-1,j,visited)) || (isValid(grid,i,j,i,j+1) && dfs(grid,i,j+1,visited));
        }
        return false;
    }
    public boolean isValid(int[][] grid, int i, int j, int ni, int nj){
        if(ni < 0 || ni >= n || nj < 0 || nj >= m) return false;
        int next = grid[ni][nj];
        if(ni == i && nj == j-1){
            return next == 1 || next == 4 || next == 6;
        }
        if(ni == i && nj == j+1){
            return next == 1 || next == 3 || next == 5;
        }
        if(ni == i-1 && nj == j){
            return next == 2 || next == 3 || next == 4;
        }
        if(ni == i+1 && nj == j){
            return next == 2 || next == 5 || next == 6;
        }
        return false;
    }
}