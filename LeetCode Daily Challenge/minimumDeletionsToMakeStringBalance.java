
public class minimumDeletionsToMakeStringBalance{
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] prefixB = new int[n + 1];
        int[] suffixA = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefixB[i + 1] = prefixB[i];
            if(s.charAt(i) == 'b'){
                prefixB[i + 1]++;
            }
        }
        for(int i = n - 1; i >= 0; i--){
            suffixA[i] = suffixA[i + 1];
            if(s.charAt(i) == 'a'){
                suffixA[i]++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++){
            ans = Math.min(ans, prefixB[i] + suffixA[i]);
        }
        return ans;
    }
}
