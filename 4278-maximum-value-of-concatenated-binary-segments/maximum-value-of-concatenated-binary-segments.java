class Solution {
    int mod = 1000000007;
    public int maxValue(int[] nums1, int[] nums0) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = nums1.length;
        int last = 0; 
        for(int i = 0; i < n; i++){
            if(nums0[i] == 0){
                last += nums1[i];
            }else{
                list.add(new int[]{nums1[i], nums0[i]});
            }
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        long ans = 0;
        long exp = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            int one = list.get(i)[0];
            int zero = list.get(i)[1];
            exp += zero;
            long first = modPow(2, exp);
            long rn = modPow(2, one);
            long val = first * ((rn - 1 + mod) % mod) % mod;
            ans = (ans + val) % mod;
            exp += one;
        }
        long first = modPow(2, exp);
        long rn = modPow(2, last);
        long val = first * ((rn - 1 + mod) % mod) % mod;
        ans = (ans + val) % mod;
        return (int) ans;
    }
    long modPow(long base, long exp){
        long res = 1;
        base %= mod;
        while(exp > 0){
            if((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}