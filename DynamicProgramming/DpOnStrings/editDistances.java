import java.util.*;
public class editDistances {
    static int [][] dp;
    static int n = 0;
    static int m = 0;
    public static int editDistance(String str1, String str2) {
        n = str1.length();
        m = str2.length();
        dp = new int[n+1][m+1];
        for(int [] d : dp){
            for(int i = 0;i < d.length;i++){
                d[i] = -1;
            }
        }
        return solve(0,0,str1,str2);
    }
    public static int solve(int i,int j,String str1,String str2){
        if(i == n && j == m){
            return 0;
        }
        if(i == n){
            return m - j;
        }
        if(j == m){
            return n - i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int delete = Integer.MAX_VALUE;
        int insert = Integer.MAX_VALUE;
        int replace = Integer.MAX_VALUE;
        int free = Integer.MAX_VALUE;
        if(str1.charAt(i) != str2.charAt(j)){
            delete = 1 + solve(i+1,j,str1,str2);
            insert = 1 + solve(i,j+1,str1,str2);
            replace = 1 + solve(i+1,j+1,str1,str2);
        }else{
            free = solve(i+1,j+1,str1,str2);
        }
        return dp[i][j] = Math.min(Math.min(delete,insert),Math.min(replace,free));
    } 
}
