class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int [][] queen = new int[n][n];
        find(queen,0,n,list);
        return ans;
    }
    public void find(int [][] queen,int j,int n,ArrayList<Integer> list){
        if(j >= n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < n;i++){
            if(!isSafe(queen,i,j)) continue;
            queen[i][j] = 1;
            list.add(n - i);
            find(queen,j + 1,n,list);
            list.remove(list.size() - 1);
            queen[i][j] = 0;
        }
    }
    public boolean isSafe(int [][] queen,int i,int j){
        int r = i;
        int c = j;
        while(r >= 0 && c >= 0){
            if(r == i && c == j){
                r--;
                c--;
                continue;
            }
            if(queen[r][c] == 1) return false;
            r--;
            c--;
        }
        r = i;
        c = j;
        while(r < queen.length && c >= 0){
            if(r == i && c == j){
                r++;
                c--;
                continue;
            }
            if(queen[r][c] == 1)return false;
            r++;
            c--;
        }
        r = i;
        c = j-1;
        while(c >= 0){
            if(queen[r][c] == 1)return false;
            c--;
        }
        return true;
    }
}