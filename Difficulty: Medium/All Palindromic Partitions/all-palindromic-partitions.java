class Solution {
    ArrayList<ArrayList<String>> ans = new ArrayList<>();
    public ArrayList<ArrayList<String>> palinParts(String s) {
        int n = s.length();
        ArrayList<String> list = new ArrayList<>();
        find(s,0,list);
        return ans;
    }
    public void find(String s,int start,List<String> list){
        if(start >= s.length()){
            ans.add(new ArrayList <>(list));
            return;
        }
        for(int i = start;i < s.length();i++){
            String nS = s.substring(start,i + 1);
            if(!isPalindrome(nS)) continue;
            list.add(nS);
            find(s,i + 1,list);
            list.remove(list.size() - 1);
        }
    }
    public boolean isPalindrome(String s){
        if(s.length() == 1) return true;
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
