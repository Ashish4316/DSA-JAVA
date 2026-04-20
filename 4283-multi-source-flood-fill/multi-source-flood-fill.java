class Solution {
    int [] dirX = {-1,1,0,0};
    int [] dirY = {0,0,-1,1};
    public int[][] colorGrid(int n, int m, int[][] sources) {
        Queue<int []> q = new LinkedList<>();
        ArrayList<int []> list = new ArrayList<>();
        int [][] mat = new int[n][m];
        for(int [] color : sources){
            mat[color[0]][color[1]] = color[2];
            list.add(new int [] {color[0],color[1],color[2]});
        }
        Collections.sort(list,(a,b) -> b[2] - a[2]);
        for(int i = 0;i < list.size();i++){
            q.add(new int [] {list.get(i)[0],list.get(i)[1]});
        }
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int [] idx = q.poll();
                int i = idx[0];
                int j = idx[1];
                for(int d = 0;d < 4;d++){
                    int newI = dirX[d] + i;
                    int newJ = dirY[d] + j;
                    if(newI >= n || newJ >= m || newI < 0 || newJ < 0 || mat[newI][newJ] != 0) continue;
                    mat[newI][newJ] = mat[i][j]; 
                    q.add(new int [] {newI,newJ});
                }
            }
        }
        return mat;
    }
}