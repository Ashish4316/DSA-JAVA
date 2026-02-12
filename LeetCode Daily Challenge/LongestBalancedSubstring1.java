public class LongestBalancedSubstring1 {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 1;
        for(int i = 0;i < s.length();i++){
            int [] freq = new int[26];
            int maxFreq = 0;
            int distinct = 0; 
            for(int j = i;j < n;j++){
                int ch  = s.charAt(j) - 'a';
                freq[ch]++;
                if(freq[ch] == 1){
                    distinct++;
                }
                maxFreq = Math.max(maxFreq,freq[ch]);
                int len = j - i + 1;
                if(distinct * maxFreq == len && ans < len){
                    ans = len;
                }
            }
        }
        return ans;
    }
}
