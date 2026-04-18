class Solution {
    int n;
    int m;
    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> ratInMaze(int[][] maze){
        n = maze.length;
        m = maze[0].length;
        find(0,0,maze,new StringBuilder(""));
        Collections.sort(ans);
        return ans;
    }
    public void find(int i,int j,int [][] maze,StringBuilder d){
        if(i == n-1 && j == m-1){
            ans.add(d.toString());
            return;
        }
        if(i < 0 || j < 0 || i >= n || j >= m || maze[i][j] == 0){
            return;
        }
        int val = maze[i][j];
        maze[i][j] = 0;
        d.append("D");
        find(i+1,j,maze,d);
        d.deleteCharAt(d.length() - 1);
        d.append("U");
        find(i-1,j,maze,d);
        d.deleteCharAt(d.length()  - 1);
        d.append("R");
        find(i,j+1,maze,d);
        d.deleteCharAt(d.length() - 1);
        d.append("L");
        find(i,j-1,maze,d);
        d.deleteCharAt(d.length() - 1);
        maze[i][j] = val;
    }
}