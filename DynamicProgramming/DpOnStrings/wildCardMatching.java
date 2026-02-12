public class wildCardMatching {
    static int n = 0;
    static int m = 0;
    static Boolean [][] dp;
	public static boolean wildcardMatching(String p, String t) {
        n = p.length();
        m = t.length();
        dp = new Boolean[n][m];
        return solve(0,0,p,t);
	}
    public static boolean solve(int i,int j,String p,String t){
        if(i == n && j == m){
            return true;
        }
        if(i == n){
            return false;
        }
        if(j == m){
            for(int k = i; k < n; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean takeStar = false;
        boolean skipStar = false;
        boolean useOneStar = false;
        boolean matched  =  false;
        if(p.charAt(i) == '*'){
            takeStar = solve(i,j+1,p,t);
            useOneStar = solve(i+1,j+1,p,t);
            skipStar = solve(i+1,j,p,t);
        }else if(p.charAt(i) == '?' || (p.charAt(i) == t.charAt(j))){
            matched = solve(i+1,j+1,p,t);
        }
        return dp[i][j] =  takeStar || skipStar || useOneStar || matched;
    }
}
