package Contest.weeklyContest488;
import java.util.*;
public class a {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0;i < n-1;i++){
            int sum = 0;
            int val = 0;
            for(int j = i + 1;j < n;j++){
                val++;
                sum += nums[j];
            }
            if(nums[i] > sum / val){
                count++;
            }
        }
        return count;
    }
}
