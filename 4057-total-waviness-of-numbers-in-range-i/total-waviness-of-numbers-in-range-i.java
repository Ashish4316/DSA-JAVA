class Solution {
    public int totalWaviness(int num1, int num2) {
        int p = num1;
        int ans = 0;

        for(int n = p;n <= num2;n++){
            String s = String.valueOf(n);
            int w = 0;
            if(s.length() >= 3){
                for(int i = 1;i < s.length() - 1;i++){
                    int a = s.charAt(i-1) - '0';
                    int b = s.charAt(i) - '0';
                    int c = s.charAt(i + 1) - '0';

                    if(b > a && b > c) w++; 
                    if(b < a && b < c) w++;
                }
            }
            ans += w;
        }
        return ans;
    }
}