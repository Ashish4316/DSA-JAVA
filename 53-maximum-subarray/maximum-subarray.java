class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int maxAns = nums[0];
        for(int i = 1;i < n;i++){
            res = Math.max(nums[i],res + nums[i]);
            maxAns = Math.max(res,maxAns);
        }
        return maxAns;
    }
}