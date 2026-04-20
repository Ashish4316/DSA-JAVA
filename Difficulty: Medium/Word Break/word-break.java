import java.util.*;

class Solution {
    Boolean[] dp;
    int maxLen = 0;

    public boolean wordBreak(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        
        
        for (String word : dictionary) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        dp = new Boolean[s.length()];
        return find(s, 0, set);
    }

    public boolean find(String s, int start, HashSet<String> set) {
        if (start == s.length()) return true;

        if (dp[start] != null) return dp[start];

        
        for (int i = start; i < s.length() && i < start + maxLen; i++) {
            String sub = s.substring(start, i + 1);

            if (!set.contains(sub)) continue;

            if (find(s, i + 1, set)) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }
}