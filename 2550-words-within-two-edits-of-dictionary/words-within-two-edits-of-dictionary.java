class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        List<String> answer = new ArrayList<>();
        for(String a : queries){
            for(String b : dictionary){
                if(a.length() != b.length()) continue;
                int edits = 0;
                for(int i = 0;i < a.length();i++){
                    if(a.charAt(i) != b.charAt(i)) edits++;
                    if(edits > 2) break;
                }
                if(edits <= 2){
                   answer.add(a);
                   break;
                }   
            }
        }
        return answer;
    }
}