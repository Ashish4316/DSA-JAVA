class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int maxEle = nums[0];
        for(int i = 1;i < n;i++){
            res = Math.max(nums[i],res + nums[i]);
            maxEle = Math.max(maxEle,res);
        }
        return maxEle;
    }
}