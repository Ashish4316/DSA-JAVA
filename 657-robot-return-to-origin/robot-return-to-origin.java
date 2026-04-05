class Solution {
    public boolean judgeCircle(String moves){
        int U = 0;
        int L = 0;
        int D = 0;
        int R = 0;
        for(int i = 0;i < moves.length();i++){
            if(moves.charAt(i) == 'U') U++;
            if(moves.charAt(i) == 'L') L++;
            if(moves.charAt(i) == 'D') D++;
            if(moves.charAt(i) == 'R') R++;
        }
        return U == D && L == R;
    }
}