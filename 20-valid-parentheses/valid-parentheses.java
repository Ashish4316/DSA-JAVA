class Solution {
    public boolean isValid(String s){
        int n = s.length();
        Stack<Character> st = new Stack<>();
        if(s.length() == 1){
            return false;
        }
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{' || st.isEmpty()) {
                st.add(ch);
                continue;
            }
            if(!st.isEmpty() && ch == ')' && st.pop() != '('){
                return false;
            }
            if(!st.isEmpty() && ch == ']' && st.pop() != '['){
                return false;
            }
            if(!st.isEmpty() && ch == '}' && st.pop() != '{'){
                return false;
            }
        }
        return st.isEmpty();
    }
}