package DynamicProgramming.KnapsackDp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class shoppingOffers {
    int m;
    HashMap<String,Integer> memo = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size(); 
        for(int i = 0; i < n; i++){
            List<Integer> offer = new ArrayList<>(Collections.nCopies(n, 0));
            offer.set(i, 1);
            offer.add(price.get(i));
            special.add(offer);
        }
        m = special.size();
        
        return solve(special,0,needs);
    }
    public int solve(List<List<Integer>> special,int i,List<Integer> needs){
        if(i == m){
            for(int j = 0;j < needs.size();j++){
                if(needs.get(j) != 0){
                    return Integer.MAX_VALUE;
                }
            }
            return 0;
        }
        String key = i + "#" + getKey(needs);
        if(memo.containsKey(key)){
            return memo.get(key);
        }   
        int notpick = solve(special,i+1,needs);
        int pick = Integer.MAX_VALUE;
        boolean possible = true;
        for(int j = 0;j < needs.size();j++){
            if(special.get(i).get(j) > needs.get(j)){
                possible = false;
                break;
            }
        }
        if(possible){
            for(int j = 0;j < needs.size();j++){
                needs.set(j, needs.get(j) - special.get(i).get(j));
            }
            int next = solve(special,i,needs);
            if(next != Integer.MAX_VALUE)
                pick = special.get(i).get(needs.size()) + next;
            for(int j = 0;j < needs.size();j++){
                needs.set(j, needs.get(j) + special.get(i).get(j));
            }
        }
        int minCost = Math.min(notpick, pick);
        memo.put(key, minCost);
        return minCost;
    }
    public String getKey(List<Integer> needs){

        StringBuilder sb = new StringBuilder();

        for(int num : needs){
            sb.append(num).append(",");
        }

        return sb.toString();
    }
}
