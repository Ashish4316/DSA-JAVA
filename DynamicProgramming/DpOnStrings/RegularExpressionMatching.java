public class  RegularExpressionMatching{
    int n;
    int m;
    Boolean [][] dp;
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        dp = new Boolean[n+1][m+1];
        return solve(0,0,s,p);
    }
    public boolean solve(int i,int j,String s,String p){
        if(j == m){
            return  i == n;
        }
        boolean currentMatch = false;
        if(i < n){
            if(dp[i][j] != null){
                return dp[i][j];
            }
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                currentMatch = true;
            }
        }
        boolean answer = false;
        if(j + 1 < m &&  p.charAt(j + 1) == '*'){
            boolean ignoreStar = solve(i,j+2,s,p);
            boolean useStar = false;
            if(currentMatch){
                useStar = solve(i+1,j,s,p);
            }
            answer = ignoreStar || useStar;
        }else{
            boolean move = false;
            if(currentMatch){
                move = solve(i+1,j+1,s,p);
            } 
            answer = answer || move;
        }
        return dp[i][j] = answer;
    }
}