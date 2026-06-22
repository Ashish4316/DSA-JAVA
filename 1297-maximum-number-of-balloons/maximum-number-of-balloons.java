class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            char ch = text.charAt(i);
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        if(map.size() < 5  || map.get('l') < 2 || map.get('o') < 2){
            return 0;
        }
        int singleChar = Math.min(map.get('n'),Math.min(map.get('b'),map.get('a')));
        int doubleChar = Math.min(map.get('l')/2,map.get('o')/2);
        return Math.min(singleChar,doubleChar);
    }
    
}