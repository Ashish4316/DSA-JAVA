class Solution {
    public String sortVowels(String s) {
        int n = s.length();   
        int [] freq = new int[26];
        int [] first = new int[26];
        Arrays.fill(first,-1);
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                freq[ch - 'a']++;
                if(first[ch - 'a'] == -1) first[ch - 'a'] = i;
            }
        }
        ArrayList<int []> list = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0) continue;
            list.add(new int [] {i, freq[i],first[i]});
        }
        Collections.sort(list, (a,b) -> {
            if(a[1] == b[1]){
                return a[2] - b[2];
            }
            return b[1] - a[1];
        });
        StringBuilder ans = new StringBuilder();
        for(int  i = 0;i < list.size();i++){
            int f = list.get(i)[1];
            int k = list.get(i)[0];
            char ch = (char)(k + 'a');
            for(int j = 1;j <= f;j++) ans.append(ch);
        }
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(!isVowel(ch)) ans.insert(i,ch);
        }
        return ans.toString();
    }
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}