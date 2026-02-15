import java.util.Arrays;

public class Champagne{
    double [][] dp = new double[101][101];
    double p;
    public double champagneTower(int poured, int query_row, int query_glass) {
        p = poured;
        for(double [] d : dp){
            Arrays.fill(d,-1.0);
        }
        return Math.min(1.0,solve(query_row,query_glass));
    }
    public double solve(int i,int j){
        if(i == 0 && j == 0){
            return p;
        }
        if(i < j || j < 0 || i < 0){
            return 0.0;
        }
        if(dp[i][j] != -1.0){
            return dp[i][j];
        }
        double left_up = (solve(i-1,j-1) - 1)/2.0;
        double right_up = (solve(i-1,j) - 1)/2.0;
        if(left_up < 0){
            left_up = 0.0;
        }
        if(right_up < 0){
            right_up = 0.0;
        }
        return dp[i][j] = left_up + right_up; 
    }
}