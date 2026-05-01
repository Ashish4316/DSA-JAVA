class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int [] ar = new int[2 * n];
        for(int i = 0; i < n; ++i){
            ar[i] = nums[i];
            ar[i + n] = nums[i];
        }
        int [] prefixSum = new int[2 * n + 1];
        for(int i = 0;i < 2 * n;i++){
            prefixSum[i + 1] = prefixSum[i] + ar[i];
        }
        int curSum = 0;
        for(int i = 0;i < n;i++){
            curSum += ar[i] * i;
        }
        int res = curSum;
        for(int i = n;i < 2 * n;i++){
            int diff = prefixSum[i] - prefixSum[i - n + 1];
            curSum = curSum - diff + ar[i] * (n - 1);
            res = Math.max(res, curSum);
        }
        return res;
    }
}