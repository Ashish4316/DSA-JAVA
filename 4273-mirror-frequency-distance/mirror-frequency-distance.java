class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character, Integer> n = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            n.put(ch, n.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        for(char ch : new HashSet<>(n.keySet())){
            int f1 = n.getOrDefault(ch, 0);
            if(f1 == 0){
                continue;
            }
            char mirror = ch;
            if(ch >= 'a' && ch <= 'z'){
                mirror = (char) ('a' + (25 - (ch - 'a')));
            } else if(ch >= '0' && ch <= '9'){
                mirror = (char) ('0' + (9 - (ch - '0')));
            }
            int f2 = n.getOrDefault(mirror, 0);
            sum += Math.abs(f1 - f2);
            n.put(ch, 0);
            n.put(mirror, 0);
        }

        return sum;
    }
}