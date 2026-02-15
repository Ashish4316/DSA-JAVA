public class LongestBalancedSubarray{
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        for(int i = 0;i < n;i++){
            int [] freq = new int[100001];
            int distEvenCount = 0;
            int distOddCount = 0;
            for(int j = i;j < n;j++){
                if(nums[j] % 2 == 0 && freq[nums[j]] == 0){
                    distEvenCount++;
                }else if(freq[nums[j]] == 0){
                    distOddCount++;
                }
                freq[nums[j]]++;
                if(distEvenCount == distOddCount){
                    maxLength = Math.max(maxLength,j - i + 1);
                }
            }
        }
        return maxLength;
    }
}