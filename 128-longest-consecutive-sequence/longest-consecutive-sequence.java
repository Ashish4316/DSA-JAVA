class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int maxLen = 0;
        for(int num : set){
            int cnt = num;
            int len = 0;
            if(!set.contains(cnt-1)){
                while(set.contains(cnt)){
                    len++;
                    cnt++;
                }
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}