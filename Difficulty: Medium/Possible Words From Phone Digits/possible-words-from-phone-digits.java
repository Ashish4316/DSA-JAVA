class Solution {
    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> possibleWords(int[] arr) {
        String [] combo = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        find(arr,0,combo,new StringBuilder(""));
        return ans;
    }
    public void find(int [] arr,int j,String [] combo,StringBuilder str){
        if(j == arr.length){
            ans.add(str.toString());
            return;
        }
        if(arr[j] == 0 || arr[j] == 1){
            find(arr, j + 1, combo, str);
            return;
        }
        for(char c : combo[arr[j]].toCharArray()){
            str.append(c);
            find(arr,j+1,combo,str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}