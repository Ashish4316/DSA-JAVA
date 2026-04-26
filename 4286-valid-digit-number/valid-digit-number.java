class Solution {
    public boolean validDigit(int n, int x){
        int c = 0;
        int d = 0;
        int N = n;
        while(n > 0){
            int r = n % 10;
            d++;
            if(r == x) c++;
            n = n / 10;
        }
        int p = (int)Math.pow(10,d-1);
        return c >= 1 && N/p != x;
    }
}