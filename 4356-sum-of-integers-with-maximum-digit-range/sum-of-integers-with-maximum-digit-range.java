class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int maxDiff = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            int num = nums[i];
            int max = -1;
            int min = 100001;
            while(num > 0){
                int rem = num % 10;
                max = Math.max(max,rem);
                min = Math.min(min,rem);
                num = num/10;
            }
            map.putIfAbsent(max-min,new ArrayList<>());
            map.get(max - min).add(i);
            maxDiff = Math.max(max - min,maxDiff);
        }
        List<Integer> list = map.get(maxDiff);
        int ans = 0;
        for(int i = 0;i < list.size();i++){
            ans += nums[list.get(i)];
        }
        return ans;
    }
}