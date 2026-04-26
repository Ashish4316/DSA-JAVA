class Solution {
    public int compareBitonicSums(int[] nums){
        long sum = 0;
        boolean inc = true;
        boolean dec = false;
        for(int i = 0;i < nums.length-1;i++){
            if(inc) sum += (long)nums[i];
            if(dec) sum -= (long)nums[i];
            if(!dec && nums[i] > nums[i+1]){
                inc = false;
                dec = true;
                sum -= (long)nums[i];
            }
        }
        if(inc) sum += (long)nums[nums.length - 1];
        if(dec) sum -= (long)nums[nums.length - 1];
        if(sum == 0) return -1;
        return sum > 0 ? 0 : 1;
    }
}
