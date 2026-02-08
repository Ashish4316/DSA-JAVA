package Contest.weeklyContest488;
import java.util.*;
public class c {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();
        long ans = 0;
        int l = 0;

        for(int r = 0;r < n;r++){
            while(!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]){
                maxD.pollLast();
            }
            maxD.addLast(r);
            while(!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]){
                minD.pollLast();
            }
            
            minD.addLast(r);
            while(l <= r){
                long max = nums[maxD.peekFirst()];
                long min = nums[minD.peekFirst()];
                long len = r - l + 1;
                long cost = (max - min) * len;

                if(cost <= k) break;

                if(maxD.peekFirst() == l){
                    maxD.pollFirst();
                }
                if(minD.peekFirst() == l){
                    minD.pollFirst();
                }
                l++;
            }
            ans += (r - l + 1);
        }
        return ans;
    }
}
