package DynamicProgramming.KnapscakDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BestTeamWithNoConflicts {
    class Pair{
        int s;
        int a;
        Pair(int s,int a){
            this.s = s;
            this.a = a;
        }
    }
    int n;
    int [][] dp;
    public int bestTeamScore(int[] scores, int[] ages) {
        n = scores.length;
        ArrayList<Pair> list = new ArrayList<>();
        dp = new int[n+1][n+1];
        for(int [] d : dp){
            Arrays.fill(d,-1);
        }
        for(int i = 0;i < n;i++){
            list.add(new Pair(scores[i],ages[i]));
        }
        Collections.sort(list, (p1,p2) -> {
            if(p1.a == p2.a) return p1.s - p2.s;
            return p1.a - p2.a;
        });

        return solve(list,0,-1);
    }
    public int solve(ArrayList<Pair> list,int i,int prevIndex){
        if(i == n){
            return 0;
        }
        if(dp[i][prevIndex + 1] != -1){
            return dp[i][prevIndex + 1];
        }
        int notpick = solve(list,i+1,prevIndex);
        int pick = 0;
        if(prevIndex == -1 || list.get(prevIndex).a == list.get(i).a || list.get(i).s >= list.get(prevIndex).s){
            pick = list.get(i).s + solve(list,i+1,i);
        }
        return dp[i][prevIndex + 1] = Math.max(notpick,pick);
    }
}
