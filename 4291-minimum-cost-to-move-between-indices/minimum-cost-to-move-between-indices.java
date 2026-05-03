class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int [] close = new int[n];
        close[0] = 1;
        close[n-1] = n - 2;
        for(int i = 1;i < n-1;i++){
            if(Math.abs(nums[i] - nums[i-1]) <= Math.abs(nums[i] - nums[i+1])){
                close[i] = i - 1;
                
            }else{
                close[i] = i + 1;
            }
        }
        long [] prefix = new long[n];
        prefix[0] = 0;
        for(int i = 1;i < n;i++){
            int cost = Math.abs(nums[i-1] - nums[i]);
            if(close[i-1] == i){
                cost = 1;
            }
            prefix[i] = prefix[i-1] + cost;
        }
        long [] suffix = new long[n];
        suffix[n-1] = 0;
        for(int i = n-2;i >= 0;i--){
            int cost = Math.abs(nums[i+1] - nums[i]);
            if(close[i+1] == i){
                cost = 1;
            }
            suffix[i] = suffix[i+1] + cost;
        }
        int [] answer = new int[queries.length];
        int i = 0;
        for(int [] queri : queries){
            int a = queri[0];
            int b = queri[1];
            if(a <= b) answer[i] = (int)(prefix[b] - prefix[a]);
            else answer[i] = (int)(suffix[b] - suffix[a]);
            i++;
        }
        return answer;
    }
}