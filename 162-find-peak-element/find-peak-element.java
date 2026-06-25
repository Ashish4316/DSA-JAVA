class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int s  = 0;
        int e  = n-1;
        while(s < e){
            int m = s + (e-s)/2;
            if(nums[m] > nums[m+1]){
                e = m;
            }else{
                s = m + 1;
            }
        }
        return s;
    }
}