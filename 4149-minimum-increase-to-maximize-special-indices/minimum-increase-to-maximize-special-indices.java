class Pair{
    int count;
    long sum;
    Pair(int count, long sum){
        this.count = count;
        this.sum = sum;
    }
}
class Solution {
    int n;
    Pair[] dp;
    public long minIncrease(int[] nums) {
        n = nums.length;
        dp = new Pair[n + 2];
        return solve(1, nums).sum;
    }
    public Pair solve(int i, int[] nums) {
        if(i >= n - 1){
            return new Pair(0, 0);
        }
        if(dp[i] != null){
            return dp[i];
        }
        int need = 0;
        if(nums[i] <= nums[i - 1] || nums[i] <= nums[i + 1]){
            need = Math.max(0, Math.max(nums[i - 1], nums[i + 1]) + 1 - nums[i]);
        }
        Pair pick = solve(i + 2, nums);
        pick = new Pair(pick.count + 1, pick.sum + need);
        Pair notPick = solve(i + 1, nums);
        dp[i] = (pick.count > notPick.count)? pick : (pick.count < notPick.count)? notPick : (pick.sum < notPick.sum)? pick : notPick;
        return dp[i];
    }
}