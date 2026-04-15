class Solution {
    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> findPermutation(String s) {
        find(0,s.toCharArray());
        return ans;
    }
    public void find(int start,char [] ch){
        if(start == ch.length - 1){
            ans.add(new String(ch));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = start;i < ch.length;i++){
            if(set.contains(ch[i])){
                continue;
            }
            set.add(ch[i]);
            swap(ch,start,i);
            find(start+1,ch);
            swap(ch,start,i);
        }
    }
    public void swap(char [] ch,int a,int b){
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
    }
}