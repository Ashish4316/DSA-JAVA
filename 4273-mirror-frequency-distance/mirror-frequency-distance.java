class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character, Integer> n = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            n.put(ch, n.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            char mirror = ch;
            if(ch >= 'a' && ch <= 'z'){
                mirror = (char) ('a' + (25 - (ch - 'a')));
            } else if(ch >= '0' && ch <= '9'){
                mirror = (char) ('0' + (9 - (ch - '0')));
            }
            String key1 = ch + "#" + mirror;
            String key2 = mirror + "#" + ch;
            if(set.contains(key1)){
                continue;
            }
            sum += Math.abs(n.getOrDefault(ch, 0) - n.getOrDefault(mirror, 0));
            set.add(key1);
            set.add(key2);
        }
        return sum;
    }
}