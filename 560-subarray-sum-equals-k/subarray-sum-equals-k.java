class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int sum = 0;
        int cnt = 0;
        for(int i = 0;i < n;i++){
            sum += nums[i];
            int need = sum - k;
            if(map.containsKey(need)){
                cnt += map.get(need);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }
}