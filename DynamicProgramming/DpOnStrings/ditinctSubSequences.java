
public class ditinctSubSequences {
    static int n;
    static int m;
    static int dp[][];
    static int mod = 1000000007;
    public static int distinctSubsequences(String str, String sub) {
        n = str.length();
        m = sub.length();
        dp = new int[n+1][m+1];
        for(int [] d : dp){
            for(int i = 0;i < d.length;i++){
                d[i] = -1;
            }
        }
        return solve(0,0,str,sub) % mod;
    }
    public static int solve(int i,int j,String s,String t){
        if(j == m){
            return 1;
        }
        if(i == n){
            return 0; 
        }
        if(dp[i][j] != -1){
            return dp[i][j] % mod;
        }
        int notPick = solve(i + 1,j,s,t);
        int pick = 0;
        if(s.charAt(i) == t.charAt(j)){
            pick = solve(i+1,j+1,s,t);
        }
        return dp[i][j] = (notPick + pick) % mod;
    }
}
