

class Solution {
    String max = "";

    public String findMaximumNum(String s, int k) {
        max = s;
        find(s.toCharArray(), 0, k, 0);
        return max;
    }

    public void find(char[] ch, int start, int k, int swap) {
        if (swap > k) return;

        if(start == ch.length - 1){
            String curr = new String(ch);
            if (curr.compareTo(max) > 0) {
                max = curr;
            }
            return;
        }

        for(int i = start; i < ch.length; i++){
            swap(ch, start, i);

            if (i == start)
                find(ch, start + 1, k, swap);
            else
                find(ch, start + 1, k, swap + 1);

            swap(ch, start, i);
        }
    }

    public void swap(char[] ch, int a, int b) {
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
    }
}