class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long [] answer = new long[n];
        HashMap<Long,long []> prefix = new HashMap<>();
        for(int i = 0;i < n;i++){
            prefix.putIfAbsent((long)nums[i],new long [] {0,0});
            long [] hp = prefix.get((long)nums[i]);
            answer[i] += Math.abs(hp[0] - hp[1] * i);
            hp[0] += i;
            hp[1] += 1;
            prefix.put((long)nums[i],hp);
        }
        HashMap<Long,long []> suffix = new HashMap<>();
        for(int i = n-1;i >= 0;i--){
            suffix.putIfAbsent((long)nums[i],new long [] {0,0});
            long [] hp = suffix.get((long)nums[i]);
            answer[i] += Math.abs(hp[0] - hp[1] * i);
            hp[0] += i;
            hp[1] += 1;
            suffix.put((long)nums[i],hp);
        }
        return answer;
    }
}