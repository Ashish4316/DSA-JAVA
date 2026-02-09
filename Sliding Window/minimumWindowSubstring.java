import java.util.*;

public class minimumWindowSubstring{
    public String minWindow(String s, String t){
        int n = s.length();
        int [] freqT = new int[128];
        int [] freqS = new int[128];
        int numOfUniq = 0;
        for(int i = 0;i < t.length();i++){
            freqT[t.charAt(i)]++;
            if(freqT[t.charAt(i)] == 1){
                numOfUniq++;
            }
        }
        int matchUniq = 0;
        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        int minI = 0;
        int minJ = 0;
        while(j < n){
            freqS[s.charAt(j)]++;
            if(freqS[s.charAt(j)] == freqT[s.charAt(j)]){
                matchUniq++;
            }
            while(i < n && matchUniq == numOfUniq){
                if(minLength > j - i + 1){
                    minLength = j - i + 1;
                    minI = i;
                    minJ = j;
                }
                freqS[s.charAt(i)]--;
                if(freqS[s.charAt(i)] < freqT[s.charAt(i)]){
                    matchUniq--;
                }
                i++;
            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minI,minJ+1);
    }
}