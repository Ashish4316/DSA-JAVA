class Solution {
    int [] dirX = {1,-1,0,0};
    int [] dirY = {0,0,1,-1};
    int n;
    int m;
    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int [][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0){
                    if(dfs(i, j, -1, -1, grid, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int x,int y,int pX,int pY,char [][] grid,int [][] visited){
        visited[x][y] = 1;
        for(int i = 0; i < 4;i++){
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == grid[x][y]){
                if(visited[newX][newY] == 0){
                    if(dfs(newX,newY,x,y,grid,visited)){
                        return true;
                    }
                }else if(pX != newX || pY != newY){
                    return true;
                }
            }
        }
        return false;
    }
}