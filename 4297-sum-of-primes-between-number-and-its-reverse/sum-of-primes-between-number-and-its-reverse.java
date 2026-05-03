class Solution {
    boolean[] isPrime = new boolean[1000 + 1];
    boolean flag = false;
    public void sieve(){
        int n = 1000;
        flag = true;
        for(int i = 2; i <= n; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i * i <= n; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= n; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public int sumOfPrimesInRange(int n){
        if(!flag){
            sieve();
        }
        int rev = 0;
        int cn = n;
        while(cn > 0){
            int rem = cn % 10;
            rev = rev * 10 + rem;
            cn = cn/10; 
        }
        int ans = 0;
        for(int i = Math.min(rev,n);i <= Math.max(rev,n);i++){
            if(isPrime[i]){
                ans += i;
            }
        }
        return ans;
    }
}