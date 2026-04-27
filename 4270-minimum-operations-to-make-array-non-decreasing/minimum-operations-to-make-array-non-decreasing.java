class Solution {
    public long minOperations(int[] nums) {
        long ans = 0;
        for(int i = 0;i < nums.length-1;i++){
            ans += Math.max((long)(nums[i] - nums[i+1]),0); 
        }
        return ans;
    }
}




